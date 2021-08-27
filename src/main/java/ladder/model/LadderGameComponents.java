package ladder.model;

public class LadderGameComponents {
    private final Players players;
    private final Ladder ladder;
    private final LadderResults results;

    public LadderGameComponents(Players players, Ladder ladder, LadderResults results) {
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

    private boolean isSameCount(int playerCount, int verticalLineCount, int resultCount) {
        return playerCount == verticalLineCount && playerCount == resultCount;
    }

    int playerCount() {
        return players.count();
    }
}
