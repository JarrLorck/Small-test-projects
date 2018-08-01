package singleton;

import java.util.HashMap;
import java.util.Map;

public class SingletonTest {

    public static void main(String[] args) throws InterruptedException {
        Map<String, String> map1 = stringsMap();
        Map<String, String> map2 = numbersMap();

        map2.replaceAll(map1::put);
        System.out.println(map1);
        System.out.println(map2);


        System.err.println("main at " + System.nanoTime());
        Thread.sleep(1000);
        Test instance = Test.getInstance();
        instance.printSomething();
//        AnotherTest instance1 = AnotherTest.INSTANCE;
//        instance1.printAnything();
    }

    private static Map<String, String> numbersMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "111");
        map.put("b", "222");
        map.put("c", "333");
        return map;
    }

    private static Map<String, String> stringsMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "aaa");
        map.put("b", "bbb");
        return map;
    }


}
