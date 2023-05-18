package refactoring;

import java.util.HashMap;
import java.util.Map;

public class MatchResults {

    private final Map<Integer, String> store = new HashMap<>();

    public void put(int position, String result) {
        store.put(position, result);
    }

    public String getResult(int position){
        return store.get(position);
    }
}
