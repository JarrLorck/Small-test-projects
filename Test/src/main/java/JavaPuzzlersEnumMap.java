import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JavaPuzzlersEnumMap {

    private enum Sex {MALE, FEMALE}

    public static void main(String[] args) {
        System.out.print(size(new HashMap<Sex, Sex>()) + " ");
        System.out.println(size(new EnumMap<Sex, Sex>(Sex.class)));
    }

    private static int size(Map<Sex, Sex> map) {
        map.put(Sex.MALE, Sex.FEMALE);
        map.put(Sex.FEMALE, Sex.MALE);
        map.put(Sex.MALE, Sex.MALE);
        map.put(Sex.FEMALE, Sex.FEMALE);
        Set<Map.Entry<Sex, Sex>> set = new HashSet<Map.Entry<Sex, Sex>>(map.entrySet());
        return set.size();
    }
}
