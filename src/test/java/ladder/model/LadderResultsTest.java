package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 결과 컬렉션 테스트")
public class LadderResultsTest {

    @DisplayName("사다리 결과 컬렉션은 주입받은 결과 목록대로 정상 생성되어야 한다.")
    @Test
    void createLadderResultsTest() {
        // given, when
        LadderResults results = new LadderResults(Arrays.asList("꽝", "5000", "꽝", "3000"));

        // then
        assertThat(results.getResults()).containsExactly("꽝", "5000", "꽝", "3000");
    }
}
