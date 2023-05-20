package refactoring.domain;

import java.util.HashMap;
import java.util.Map;

public class MatchResults implements Match {

    private final Map<Integer, String> store = new HashMap<>();

    @Override
    public void put(int position, String result) {
        store.put(position, result);
    }
    @Override
    public String getResult(int position){
        return store.get(position);
    }

    @Override
    public Map<Integer, String> getAll() {
        return store;
    }
}
