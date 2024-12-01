package org.pgm.shopserver.service;

import org.pgm.shopserver.dto.PurchaseDTO;
import org.pgm.shopserver.model.Purchase;
import org.pgm.shopserver.repository.projection.PurchaseItem;

import java.util.List;

public interface PurchaseService {
    Purchase savePurchase(PurchaseDTO purchaseDTO);
    List<PurchaseItem> findPurchaseItemsOfUser(String username);
    //실제로 데이터를 입력할 때는 username이나 productid만 가져옴.
    //화면에 뿌릴 때 dto에는 상품정보 모두가 필요하므로 purchase로 리턴하도록 함
    List<Purchase> findAllPurchases();
    void deletePurchase(Long id);
    }
