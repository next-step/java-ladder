package ladder.domain;

public class Index {
    private static final int INDEX_MIN = 0;
    private static final String INDEX_MIN_EXCEPTION_STATEMENT = "인덱스가 %d미만의 값으로 세팅시도 하였습니다.";

    private int index;

    private Index(int index) {
        validate(index);
        this.index = index;
    }

    public static Index from(int index) {
        return new Index(index);
    }

    private void validate(int index) {
        if (index < INDEX_MIN) {
            throw new IndexOutOfBoundsException(String.format(INDEX_MIN_EXCEPTION_STATEMENT, INDEX_MIN));
        }
    }

    public void moveOf(final LadderLine ladderLine) {
        if (ladderLine.existLeftOf(Index.from(index))) {
            this.index--;
            return;
        }

        if (ladderLine.existRightOf(Index.from(index))) {
            this.index++;
        }
    }

    public int val() {
        return index;
    }
}
