package nextstep.ladder;

import nextstep.ladder.domain.LadderResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderResultsTest {
    @Test
    @DisplayName("입력받은 결과의 길이는 5글자가 넘으면 안된다.")
    void assertResultLength() {

        List<String> results = new ArrayList<>();
        String result = "꽝꽝꽝꽝꽝꽝";
        results.add(result);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderResults(results);
        }).withMessage(String.format(LadderResults.LADDER_RESULT_LENGTH_ERROR, result));
    }
}
