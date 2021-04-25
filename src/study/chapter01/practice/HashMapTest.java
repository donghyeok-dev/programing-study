package study.chapter01.practice;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.SortedMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, HProduct> hashMap = new HashMap<>(10);
        hashMap.put("computer", HProduct.builder().productCode(1001L).productName("맥북프로").amount(2000000).build());
        hashMap.put("phone", HProduct.builder().productCode(1002L).productName("겔럭시").amount(1000000).build());
        hashMap.put("book", HProduct.builder().productCode(1003L).productName("TDD").amount(25000).build());
        hashMap.put("phone", HProduct.builder().productCode(1004L).productName("겔럭시2").amount(1000000).build());
        hashMap.put(null, HProduct.builder().productCode(1004L).productName("겔럭시3").amount(1000000).build()); //ok

        System.out.println(">>> size: " + hashMap.size());

        hashMap.forEach((s, hProduct) -> System.out.println("key : " + s + " value: " + hProduct));

//        hashMap
//        public final int hashCode() {
              //키와 값의 해쉬값을 XOR 연산 결과로 리턴 한다.
//            return Objects.hashCode(key) ^ Objects.hashCode(value);
//        }

//        Iterator<String> iterator = hashMap.keySet().iterator();
//
////        iterator.remove(); //IllegalStateException: Hashtable Enumerator
//
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

//        hashMap.remove("phone");
//        System.out.println(hashMap.containsKey("phone"));

        //hashMap.forEach((s, hProduct) -> System.out.println("key hashcode: " + s.hashCode() + " value hashcode: " + hProduct.hashCode()));



        hashMap.clear();

        System.out.println(halfOverValue(new int[]{1,2,3,1,4,5,3,3,7,8,9,0,2,4,5,4,3,2,6,7,8,3,5,3,6,3,6,8,3,6,8,3,6,5,9,6,3,1,4,3,5,4,2,5,2,6}));
    }

    public static int halfOverValue(int[] numbers) {
        HashMap<Integer, Integer> data = new HashMap<>();
        int topKey=0;
        int topCount=0;

        for (int num : numbers) {
            int tempCount = data.containsKey(num) ? data.get(num)+1 : 1;
            data.put(num, tempCount);
            if (tempCount > topCount) {
                topKey = num;
                topCount = tempCount;
            }
        }

        return topKey;
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

    @Override
    public boolean equals(Object o) {
        System.out.println(">>> this.productCode: " +  this.productCode + " equals called!");
        if(this == o) { return true; }
        HProduct hp = (HProduct) o;
        return (Objects.equals(this.productCode, hp.productCode)
                && Objects.equals(this.productName, hp.productName)
                && this.amount == hp.amount);
    }

    @Override
    public int hashCode() {
        System.out.println(">>> this.productCode: " +  this.productCode + " hashCode called!");
        return Objects.hash(this.productCode, this.productName, this.amount);
    }
}
