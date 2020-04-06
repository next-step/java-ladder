package nextstep.ladder.domain;

import java.util.List;

public class LadderResults {
    public static final String LADDER_RESULT_LENGTH_ERROR = "실행 결과는 5자 이하로 입력해주세요. [실행 결과: %s]";
    private final List<String> results;

    public LadderResults(List<String> results) {
        for(String result : results) {
            assertResultName(result);
        }

        this.results = results;
    }

    private void assertResultName(String result) {
        if(result.length() > 5) {
            throw new IllegalArgumentException(String.format(LADDER_RESULT_LENGTH_ERROR, result));
        }
    }

    public int getSize() {
        return results.size();
    }

    public String getByPosition(int endPosition) {
        return results.get(endPosition);
    }
}
