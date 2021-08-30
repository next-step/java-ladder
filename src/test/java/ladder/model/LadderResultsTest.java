package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 실행 결과값 컬렉션 테스트")
public class LadderResultsTest {

    @DisplayName("사다리 실행 결과값 컬렉션은 주입받은 결과 목록대로 정상 생성되어야 한다.")
    @Test
    void createLadderResultsTest() {
        // given, when
        LadderResults results = new LadderResults(Arrays.asList("꽝", "5000", "꽝", "3000"));

        // then
        assertThat(results.getResults()).containsExactly("꽝", "5000", "꽝", "3000");
    }

    @DisplayName("사다리 실행 결과값 생성시, 값이 없으면 예외가 발생한다.")
    @Test
    void emptyLadderResultsExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderResults(Collections.emptyList()))
                .withMessage("사다리 실행 결과값이 비었습니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderResults(null))
                .withMessage("사다리 실행 결과값이 비었습니다.");
    }
}
