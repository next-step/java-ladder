package ladder.domain;

import java.util.Objects;

/**
 * 실행 결과를 나타내는 포장용 클래스
 * 불변 객체입니다.
 */
public class Result {
    private final String result;

    public Result(String result) {
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
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return this.result;
    }
}