package nextstep.ladder.domain;

import java.util.List;

public class LadderResults {
    private List<Player> players;
    private List<String> results;

    public LadderResults(List<Player> players, List<String> results) {
        if (players.size() != results.size()) {
            throw new IllegalArgumentException("결과 수와 참여자 수는 같아야 합니다.");
        }
        this.players = players;
        this.results = results;
    }
}
