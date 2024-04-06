package laddergame.domain;

import java.util.Map;
import java.util.Optional;

public class ResultOfLadder {
    public static final String NOT_EXIST_PLAYER = "존재하지 않는 참여자 입니다.";

    private final Map<Player, WinningContent> results;

    public ResultOfLadder(Map<Player, WinningContent> results) {
        this.results = results;
    }

    public String winningContentOfPlayer(Player player) {
        return Optional.ofNullable(results.get(player))
                .map(WinningContent::winningContent)
                .orElse(NOT_EXIST_PLAYER);
    }
}
