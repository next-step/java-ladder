package seungjun.ladder;

import ladder.LadderResultItem;

import java.util.Objects;

/**
 * 실행 결과를 나타내는 포장용 클래스
 * 불변 객체입니다.
 */
public class ResultItem implements LadderResultItem {
    private final String result;

    public ResultItem(String result) {
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
        ResultItem resultItem1 = (ResultItem) o;
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

    @Override
    public String toPrintableString() {
        return this.result;
    }
}