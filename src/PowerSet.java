import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    private List<String> set;

    public PowerSet() {
        set = new ArrayList<>();
    }

    public int size() {
        return set.size();
    }

    public void put(String value) {
        if (!set.contains(value)) {
            set.add(value);
        }
    }

    public boolean get(String value) {
        return set.contains(value);
    }

    public boolean remove(String value) {
        return set.remove(value);
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet result = new PowerSet();
        for (String value : set) {
            if (set2.get(value)) {
                result.put(value);
            }
        }
        return result;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet result = new PowerSet();
        result.set.addAll(set);
        for (String value : set2.set) {
            result.put(value);
        }
        return result;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet result = new PowerSet();
        for (String value : set) {
            if (!set2.get(value)) {
                result.put(value);
            }
        }
        return result;
    }

    public boolean isSubset(PowerSet set2) {
        for (String value : set2.set) {
            if (!set.contains(value)) {
                return false;
            }
        }
        return true;
    }
}