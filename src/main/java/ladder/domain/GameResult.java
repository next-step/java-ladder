package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GameResult {
    private final Map<String, String> map;

    private GameResult(Map<String, String> map) {
        this.map = map;
    }

    public static GameResult of(Participant participant, Results finalResults) {
        Map<String, String> map = new HashMap<>();

        List<String> participantList = participant.getList();
        List<String> finalResultsList = finalResults.getList();

        for (int i = 0; i < participant.size(); i++) {
            map.put(participantList.get(i), finalResultsList.get(i));
        }

        return new GameResult(map);
    }

    public Map<String, String> getMap() {
        return map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(map, that.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }
}
