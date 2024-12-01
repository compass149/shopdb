package org.pgm.shopserver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.pgm.shopserver.dto.PurchaseDTO;
import org.pgm.shopserver.model.Product;
import org.pgm.shopserver.model.Purchase;
import org.pgm.shopserver.model.User;
import org.pgm.shopserver.repository.ProductRepository;
import org.pgm.shopserver.repository.PurchaseRepository;
import org.pgm.shopserver.repository.UserRepository;
import org.pgm.shopserver.repository.projection.PurchaseItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public Purchase savePurchase(PurchaseDTO purchaseDTO) {
        Purchase purchase = Purchase.builder()
                .quantity(purchaseDTO.getQuantity())
                .build();
        User user = userRepository.findByUsername(purchaseDTO.getUsername());
        Product product = productRepository.findById(purchaseDTO.getProductId()).orElseThrow();

        purchase.setUser(user);
        purchase.setProduct(product);
        purchase.setPurchaseTime(LocalDateTime.now()); //구매일자 저장

        Purchase savedPurchase = purchaseRepository.save(purchase);
        return savedPurchase;
    }

    @Override
    public List<PurchaseItem> findPurchaseItemsOfUser(String username) {
        User user = userRepository.findByUsername(username);
        List<PurchaseItem> purchaseItems=purchaseRepository.findAllPurchasesOfUser(username);
        purchaseItems.forEach(purchaseItem->{
            log.info(purchaseItem.getQuantity());
            log.info(purchaseItem.getPurchaseTime());
        });
        return purchaseRepository.findAllPurchasesOfUser(username);
    }

    @Override
    public List<Purchase> findAllPurchases() {
        return purchaseRepository.findAll();
    }

    @Override
    public void deletePurchase(Long id) {
        purchaseRepository.deleteById(id);
    }
}
