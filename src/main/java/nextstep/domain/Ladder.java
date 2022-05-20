package nextstep.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final LadderLines ladderLines;
    private final LadderResult ladderResult;

    public Ladder(int userCount, LadderHeight ladderHeight, LadderResult ladderResult) {
        validate(userCount, ladderResult);
        this.ladderLines = new LadderLines(IntStream.range(0, ladderHeight.getHeight())
                .mapToObj(i -> new LadderLine(LadderLineGenerator.generate(userCount - 1)))
                .collect(Collectors.toList()));
        this.ladderResult = ladderResult;
    }

    private void validate(int userCount, LadderResult ladderResult) {
        if (userCount != ladderResult.getResultSize()) {
            throw new IllegalArgumentException("실행 결과의 개수와 유저 수는 같아야 합니다.");
        }
    }

    public List<LadderLine> getLadderLines() {
        return this.ladderLines.getLadderLines();
    }

    public void moveLadderLines() {
        this.ladderLines.moveLines(this.ladderResult);
    }

    public String find(int userIndex) {
        return this.ladderResult.find(userIndex);
    }

    public LadderResult getLadderResult() {
        return ladderResult;
    }
}
