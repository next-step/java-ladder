package ladder.domain;

import ladder.exception.LadderException;

public class LadderGame {

    private static final String USER_AND_RESULT_COUNT_MATCH_ERR_MST =
            "참가자와 게임 결과의 수가 일치해야 합니다.";

    private final Players players;
    private final Lines lines;
    private final LadderGameResult ladderGameResult;

    public LadderGame(Players players, Lines lines, LadderGameResult result) {
        validateUserAndResult(players, result);
        this.players = players;
        this.lines = lines;
        this.ladderGameResult = result;
    }

    public static LadderGame of(final Players players,
                                final int height,
                                final LadderGameResult result) {
        Lines lines = Lines.of(players.getPlayersCount(), height);

        return new LadderGame(players, lines, result);
    }

    private void validateUserAndResult(Players players, LadderGameResult result) {
        if (players.getPlayersCount() != result.size()) {
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
