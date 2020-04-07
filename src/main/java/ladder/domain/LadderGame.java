package ladder.domain;

import ladder.exception.LadderException;

public class LadderGame {

    private static final String USER_AND_RESULT_COUNT_MATCH_ERR_MST =
            "참가자와 게임 결과의 수가 일치해야 합니다.";

    private final Players players;
    private final Lines lines;
    private final LadderPrize ladderPrize;

    public LadderGame(Players players, Lines lines, LadderPrize result) {
        validateUserAndResult(players, result);
        this.players = players;
        this.lines = lines;
        this.ladderPrize = result;
    }

    public static LadderGame of(final Players players,
                                final int height,
                                final LadderPrize result) {
        Lines lines = Lines.of(players.size(), height);

        return new LadderGame(players, lines, result);
    }

    private void validateUserAndResult(Players players, LadderPrize result) {
        if (players.size() != result.size()) {
            throw new LadderException(USER_AND_RESULT_COUNT_MATCH_ERR_MST);
        }
    }

    public Node getPlayerResult(String playerName) {
        int playerIndex = players.findPlayer(playerName);
        return lines.move(playerIndex);
    }

    public Lines getLines() {
        return lines;
    }

    public Players getPlayers() {
        return players;
    }
}
