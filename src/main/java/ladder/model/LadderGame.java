package ladder.model;

import java.util.List;

public class LadderGame {
    private static final int FIRST_INDEX = 0;

    private final Players players;
    private final Ladder ladder;
    private final LadderResults results;

    public LadderGame(Players players, Ladder ladder, LadderResults results) {
        validateCountMatch(players, ladder, results);

        this.players = players;
        this.ladder = ladder;
        this.results = results;
    }

    private void validateCountMatch(Players players, Ladder ladder, LadderResults results) {
        if (isSameCount(players.count(), ladder.playerCount(), results.count())) {
            return;
        }
        throw new IllegalArgumentException("플레이어 수, 사다리 참가자 수, 사다리 결과의 개수가 일치하지 않습니다.");
    }

    private boolean isSameCount(int playerCountOfPlayers, int playerCountOfLadder, int resultCount) {
        return playerCountOfPlayers == playerCountOfLadder && playerCountOfPlayers == resultCount;
    }

    int playerCount() {
        return players.count();
    }

    public String findResult(String name) {
        PlayerName player = new PlayerName(name);

        int playerIndex = players.findIndex(player);
        validateExistingPlayer(playerIndex);

        int resultIndex = ladder.findResultIndex(playerIndex);
        return results.get(resultIndex);
    }

    private void validateExistingPlayer(int playerIndex) {
        if (playerIndex < FIRST_INDEX) {
            throw new IllegalArgumentException("존재하지 않는 플레이어입니다.");
        }
    }

    public List<String> getPlayerNames() {
        return players.getNames();
    }

    public List<LadderLine> getLadderLines() {
        return ladder.getLines();
    }

    public List<String> getLadderResults() {
        return results.getResults();
    }
}
