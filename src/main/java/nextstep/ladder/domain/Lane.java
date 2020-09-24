package nextstep.ladder.domain;

public class Lane {

    private final int indexLimit;
    private final int index;

    private Lane(int indexLimit, int index) {
        this.indexLimit = indexLimit;
        this.index = index;
    }

    public static Lane of(int countOfPerson, int index) {
        int indexLimit = countOfPerson - 1;
        validateRange(indexLimit, index);
        return new Lane(indexLimit, index);
    }

    public Lane move(int index) {
        validateRange(index);
        return new Lane(indexLimit, index);
    }

    private void validateRange(int index) {
        validateRange(indexLimit, index);
    }

    private static void validateRange(int indexLimit, int index) {
        if (index < 0 || index > indexLimit) {
            throw new IllegalArgumentException("유효한 인덱스 범위를 벗어났습니다.");
        }
    }
}
