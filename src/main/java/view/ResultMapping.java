package view;

import domain.PlayerName;

import java.util.*;

public class ResultMapping {
    private final Map<PlayerName, String> results;

    public ResultMapping(List<PlayerName> names, List<String> outcomes) {
        if (names.size() != outcomes.size()) {
            throw new IllegalArgumentException("이름과 결과의 수가 같아야 합니다.");
        }
        results = new LinkedHashMap<>();
        for (int i = 0; i < names.size(); i++) {
            results.put(names.get(i), outcomes.get(i));
        }
    }

    public String getResult(PlayerName player) {
        return results.get(player);
    }

    public Map<PlayerName, String> getAllResults() {
        return Collections.unmodifiableMap(results);
    }
}