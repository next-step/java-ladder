package ladder;

import java.util.Objects;

/**
 * 실행 결과를 나타내는 포장용 클래스
 * 불변 객체입니다.
 */
public class LadderResultItem {
    private final String result;

    public LadderResultItem(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderResultItem resultItem1 = (LadderResultItem) o;
        return Objects.equals(result, resultItem1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return this.result;
    }

    public String toPrintableString() {
        return this.result;
    }
}