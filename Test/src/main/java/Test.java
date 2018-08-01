import java.util.HashMap;
import java.util.Map;

public class Test {

    public Test() {
    }

    public void test() {
        long time = System.currentTimeMillis();
        HashMap<String, String> hm = new HashMap<>();
        hm.put("now", "bar");
        Map<String, String> m = hm;
        m.put("foo", "baz");
    }
}
