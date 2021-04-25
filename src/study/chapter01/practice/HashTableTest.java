package study.chapter01.practice;

import java.util.Hashtable;
import java.util.Iterator;

public class HashTableTest {
    public static void main(String[] args) {
        Hashtable<String, HProduct> hashtable = new Hashtable<>(10);

        hashtable.put("computer", HProduct.builder().productCode(1001L).productName("맥북프로").amount(2000000).build());
        hashtable.put("phone", HProduct.builder().productCode(1002L).productName("겔럭시").amount(1000000).build());
        hashtable.put("book", HProduct.builder().productCode(1003L).productName("TDD").amount(25000).build());
        hashtable.put("phone", HProduct.builder().productCode(1004L).productName("겔럭시2").amount(1000000).build());
        //hashtable.put(null, HProduct.builder().productCode(1004L).productName("겔럭시3").amount(1000000).build());

        System.out.println(">>> size: " + hashtable.size());
        hashtable.forEach((s, hProduct) -> System.out.println("key hashcode: " + s.hashCode() + " value: " + hProduct));

//        Iterator<String> iterator = hashtable.keySet().iterator(); // fail-fast Enumeration
//
//        iterator.remove(); //IllegalStateException: Hashtable Enumerator
//
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        /*
        static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }
         */
        int h = "computer".hashCode();
        System.out.println(Integer.toBinaryString(h)); // 32bit hashcode
        System.out.println(Integer.toBinaryString(h >>> 16)); // hashcode에서 앞에 16bit만으로 버킷 주소 값 구함
        System.out.println(h >>> 16);
    }
}