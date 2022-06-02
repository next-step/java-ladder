package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ResultMap {
    private final HashMap<String, String> resultMap;
//    public ResultMap(HashMap<String, String> resultMap) {
    public ResultMap() {
        this.resultMap = new HashMap<>();
    }
    public void put(String player1, String reward) {
        this.resultMap.put(player1, reward);
    }

    public String get(String player) {
        return this.resultMap.get(player);
    }

    public Set<Map.Entry<String, String>> getAllAsList() {
        return this.resultMap.entrySet();
    }
}
