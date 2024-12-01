package org.pgm.shopserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDTO {  //여기에 있는 것을 react랑 연결할 때 구매한 것을 여기에 있는 것으로 사용할 예정
    private Long id;
    private String username;
    private Long productId; //상품 선택할 때 자동으로 productId가 들어가게 할 예정임
    private Integer quantity;
    private LocalDateTime purchaseTime; //입출력 시 하나는 enttity, 하나는 dto 사용해도 됨
//form에서 입력받는 것과 db에 저장되는 것이 다르면 반드시 dto가 필요함

}
