package study.chapter01.practice;

import java.util.*;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String, HProduct> treeMap = new TreeMap<>();
        treeMap.put("computer", HProduct.builder().productCode(1001L).productName("맥북프로").amount(2000000).build());
        treeMap.put("phone", HProduct.builder().productCode(1002L).productName("겔럭시").amount(1000000).build());
        treeMap.put("book", HProduct.builder().productCode(1003L).productName("TDD").amount(25000).build());
        treeMap.put("phone", HProduct.builder().productCode(1004L).productName("겔럭시2").amount(1000000).build());
//        treeMap.put(null, HProduct.builder().productCode(1004L).productName("겔럭시3").amount(1000000).build());

        System.out.println(">>> size: " + treeMap.size());

        treeMap.forEach((s, hProduct) -> System.out.println("key hashcode: " + s.hashCode() + " value: " + hProduct));

        for(Map.Entry<String, HProduct> entry : treeMap.entrySet()) {
            System.out.println("entry: " + entry.getKey() + " value: " + entry.getValue());
        }

        Iterator<String> iterator = treeMap.keySet().iterator(); // fail-fast Enumeration

        //iterator.remove(); //IllegalStateException: Hashtable Enumerator

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        TreeSet<String> treeSet = new TreeSet<>();
        treeMap.put("computer", HProduct.builder().productCode(1001L).productName("맥북프로").amount(2000000).build());
        treeMap.put("phone", HProduct.builder().productCode(1002L).productName("겔럭시").amount(1000000).build());
        treeMap.put("book", HProduct.builder().productCode(1003L).productName("TDD").amount(25000).build());
        treeMap.put("phone", HProduct.builder().productCode(1004L).productName("겔럭시2").amount(1000000).build());
    }
}
