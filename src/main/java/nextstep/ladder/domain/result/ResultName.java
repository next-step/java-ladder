package nextstep.ladder.domain.result;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ResultName {

    private static final List<String> resultList = Arrays.asList("꽝", "당첨");
    private static final String RESULT_NAME_FORMAT = "[0-9]*";

    private final String name;

    public ResultName(String name) {
        validateResultName(name);
        this.name = name;
    }

    private void validateResultName(String name) {
        if (name.matches(RESULT_NAME_FORMAT) || resultList.contains(name)) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 결과 형식에 맞지 않습니다.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultName that = (ResultName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
