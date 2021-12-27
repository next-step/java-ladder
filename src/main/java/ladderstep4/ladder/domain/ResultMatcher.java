package ladderstep4.ladder.domain;

import java.util.List;

public class ResultMatcher {
    public static final String WRONG_PARAMETER_VALUE_MESSAGE = "결과를 만들기 위한 파라미터들이 올바르지 않습니다.";

    private final Players players;
    private final PlayResult playResult;
    private final Prizes prizes;

    public ResultMatcher(Players players, PlayResult playResult, Prizes prizes) {
        if (players.size() != playResult.size() || playResult.size() != prizes.size() ) {
            throw new IllegalArgumentException(WRONG_PARAMETER_VALUE_MESSAGE);
        }
        this.players = players;
        this.playResult = playResult;
        this.prizes = prizes;
    }

    public Prize match(String name) {
        Position start = players.findPositionOf(new Player(name));
        Position end = playResult.get(start);
        return prizes.findPrize(end);
    }

    public List<Player> getPlayers() {
        return players.getValues();
    }
}
