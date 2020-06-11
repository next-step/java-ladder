package ladder.domain.ladder;

public class LineCount {
    private final int lineCount;

    private LineCount(int personCount) {
        this.lineCount = personCount -1;
    }

    public static LineCount inputLineCount(final int personCount) {
        validateLineCount(personCount);
        return new LineCount(personCount);
    }

    public int getLineCount() {
        return lineCount;
    }

    private static void validateLineCount(int personCount) {
        if (personCount < 2) {
            throw new IllegalArgumentException("라인의 갯수는 2 보다 작을 수 없습니다.");
        }
    }
}
