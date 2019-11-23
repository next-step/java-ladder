package nextstep.ladder.domain.game;

import nextstep.StringUtils;

import java.util.Collections;
import java.util.List;

import static nextstep.StringUtils.COMMA;

public class LadderResults {

    private static final String INVALID_POSITION = "결과를 가져올 수 없습니다. 위치를 다시 확인해주세요.";
    private final List<String> lineResults;

    public LadderResults(String resultsText) {
        this.lineResults = StringUtils.splitBy(COMMA, resultsText);
    }

    public String findBy(int position) {
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
