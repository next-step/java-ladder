package nextstep.ladder.domain;

import java.util.List;

public class LadderResults {
    private List<Player> players;
    private List<String> results;


    public LadderResults(List<Player> players, List<String> results) {
        this.players = players;
        this.results = results;
    }
}
