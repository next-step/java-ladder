package nextstep.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int USER_INDEX_POINT = 6;
    private final LadderLines ladderLines;
    private final LadderResult ladderResult;

    public Ladder(int userCount, LadderHeight ladderHeight, LadderResult ladderResult) {
        this.ladderLines = new LadderLines(IntStream.range(0, ladderHeight.getHeight())
                .mapToObj(i -> new LadderLine(LadderLineGenerator.generate(userCount - 1)))
                .collect(Collectors.toList()));
        this.ladderResult = ladderResult;
        validate(userCount);
    }

    private void validate(int userCount) {
        if (userCount != this.ladderResult.getResult().size()) {
            throw new IllegalArgumentException("실행 결과의 개수와 유저 수는 같아야 합니다.");
        }
    }

    public List<LadderLine> getLadderLines() {
        return this.ladderLines.getLadderLines();
    }

    public void moveLines() {
        int result = 0;
        for (int i = 0; i <= this.ladderLines.getLadderLines().get(0).getPoints().size(); i += 6) {
            result = move(i);
            ladderResult.addResultIndex(result);
        }
    }

    public int move(int k) {
        int userPoint = k;
        for (int i = 0; i < this.ladderLines.getLadderLines().size(); i++) {
            userPoint = this.ladderLines.getLadderLines()
                    .get(i)
                    .moveLadderLine(userPoint);
        }
        return userPoint;
    }

    public String find(int userIndex) {
        if (userIndex < 0) {
            throw new IllegalArgumentException("유저를 찾을 수 없습니다.");
        }
        return this.ladderResult.getResult()
                .get(ladderResult.getResultIndex().get(userIndex) / USER_INDEX_POINT);
    }

    public LadderResult getLadderResult() {
        return ladderResult;
    }
}
