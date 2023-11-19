package ladder;

import ladder.domain.Line;
import ladder.exception.LineDuplicateException;
import ladder.fixture.FixedPointFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LineTest {

    @Test
    @DisplayName("가로 라인이 겹칠 경우 에러 발생한다")
    public void line_duplicate() {
        assertThatExceptionOfType(LineDuplicateException.class)
            .isThrownBy(() -> {
                new Line(4, new FixedPointFactory(Arrays.asList(false, true, true)));
            })
            .withMessageMatching("가로 라인은 겹칠 수 없습니다");
    }

}
