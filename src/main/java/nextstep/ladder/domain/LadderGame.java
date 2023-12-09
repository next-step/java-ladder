package nextstep.ladder.domain;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;
    private final Amounts amounts;

    public LadderGame(Players players, Ladder ladder, Amounts amounts) {
        validate(players, amounts);

        this.players = players;
        this.ladder = ladder;
        this.amounts = amounts;
    }

    private void validate(Players players, Amounts amounts) {
        checkPlayersAndAmountsSizeSame(players, amounts);
    }

    private void checkPlayersAndAmountsSizeSame(Players players, Amounts amounts) {
        if (players.size() != amounts.size()) {
            throw new IllegalArgumentException("참가자와 사다리 결과의 수는 같아야 합니다.");
        }
    }

    public LadderGameResult realPlay() {
        LadderGameResult ladderGameResult = new LadderGameResult();
        for (int index = 0; index < players.size(); index++) {
            int resultIndex = ladder.move(index);
            ladderGameResult.put(players.find(index), amounts.find(resultIndex));
        }

        return ladderGameResult;
    }
}
