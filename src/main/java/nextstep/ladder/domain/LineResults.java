package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class LineResults {

    private static final String INVALID_POSITION = "결과를 가져올 수 없습니다. 위치를 다시 확인해주세요.";
    private final List<String> lineResults;

    public LineResults(List<String> results) {
        this.lineResults = results;
    }

    public String match(int position) {
        assertPositionRange(position);
        return lineResults.get(position);
    }

    public List<String> getValue() {
        return Collections.unmodifiableList(lineResults);
    }

    private void assertPositionRange(int position) {
        if (position < 0 || position >= lineResults.size()) {
            throw new IllegalArgumentException(INVALID_POSITION);
        }
    }
}
