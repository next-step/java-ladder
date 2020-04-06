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
        results.add("꽝꽝꽝꽝꽝꽝");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderResults(results);
        }).withMessage("실행 결과는 5자 이하로 입력해주세요. [실행 결과: %s]")
    }
}
