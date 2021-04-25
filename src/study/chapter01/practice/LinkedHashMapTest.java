package study.chapter01.practice;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, HProduct> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("computer", HProduct.builder().productCode(1001L).productName("맥북프로").amount(2000000).build());
        linkedHashMap.put("phone", HProduct.builder().productCode(1002L).productName("겔럭시").amount(1000000).build());
        linkedHashMap.put("book", HProduct.builder().productCode(1003L).productName("TDD").amount(25000).build());
        linkedHashMap.put("phone", HProduct.builder().productCode(1004L).productName("겔럭시2").amount(1000000).build());
//        linkedHashMap.put(null, HProduct.builder().productCode(1004L).productName("겔럭시3").amount(1000000).build());

        System.out.println(">>> size: " + linkedHashMap.size());

        linkedHashMap.forEach((s, hProduct) -> System.out.println("key hashcode: " + s.hashCode() + " value: " + hProduct));

        for(Map.Entry<String, HProduct> entry : linkedHashMap.entrySet()) {
            System.out.println("entry: " + entry.getKey() + " value: " + entry.getValue());
        }

        Iterator<String> iterator = linkedHashMap.keySet().iterator(); // fail-fast Enumeration

        //iterator.remove(); //IllegalStateException: Hashtable Enumerator

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
