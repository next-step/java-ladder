package nextstep.ladder;

public class LadderResult {
    private final Ladder ladder;
    private final Results results;

    private LadderResult(Ladder ladder, Results results) {
        validation(ladder, results);
        this.ladder = ladder;
        this.results = results;
    }

    private void validation(Ladder ladder, Results results) {
        if (results.size() != ladder.sizeOfPlayers())
            throw new IllegalArgumentException("사다리 결과는 사다리 참가자 수와 같아야 합니다.");
    }

    public static LadderResult of(Ladder ladder, Results results) {
        return new LadderResult(ladder, results);
    }

    public String ladderResult(int startPosition) {
        int resultPosition = ladder.lastLadderPosition(startPosition);
        return results.result(resultPosition);
    }
}

