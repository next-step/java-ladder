package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;

public class Results {

    private static final String INVALID_RESULT = "실행결과는 참여할 사람의 수만큼 입력되어야합니다.";

    private List<String> results;

    public Results(String [] results) {
        this.results = Arrays.asList(results);
    }

    public void validate(int validLength) {
        if (results == null || results.size() != validLength) {
            throw new IllegalArgumentException(INVALID_RESULT);
        }
    }

    public String getResult(int index) {
        return results.get(index);
    }
}
