package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class ResultRecord {
    private final List<ResultOfPlayer> resultOfPlayers;

    public ResultRecord() {
        this.resultOfPlayers = new ArrayList<>();
    }

    public void add(ResultOfPlayer resultOfPlayer) {
        resultOfPlayers.add(resultOfPlayer);
    }

    public ResultOfPlayer find(String playerName) {
        return resultOfPlayers.stream()
                .filter(v -> v.getPlayerName().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 이름이 없습니다."));
    }

    public List<ResultOfPlayer> getResultOfPlayers() {
        return resultOfPlayers;
    }
}
