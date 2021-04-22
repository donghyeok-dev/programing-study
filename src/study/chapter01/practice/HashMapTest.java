package study.chapter01.practice;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, HProduct> hashMap = new HashMap<>(3);
        hashMap.put("computer", HProduct.builder().productCode(1001L).productName("맥북프로").amount(2000000).build());
        hashMap.put("phone", HProduct.builder().productCode(1001L).productName("겔럭시").amount(1000000).build());
        hashMap.put("book", HProduct.builder().productCode(1001L).productName("TDD").amount(25000).build());

        hashMap.forEach((s, hProduct) -> System.out.println("key : " + s + " value: " + hProduct));
    }
}

@Getter
@ToString
class HProduct {
    Long productCode;
    String productName;
    int amount;

    @Builder
    public HProduct(Long productCode, String productName, int amount) {
        this.productCode = productCode;
        this.productName = productName;
        this.amount = amount;
    }
}
