package ladder;

import ladder.domain.Row;
import ladder.exception.LineDuplicateException;
import ladder.fixture.FixedColFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class RowTest {

    @Test
    @DisplayName("가로 라인이 겹칠 경우 에러 발생한다")
    public void line_duplicate() {
        assertThatExceptionOfType(LineDuplicateException.class)
            .isThrownBy(() -> {
                new Row(3, new FixedColFactory(Arrays.asList(false, true, true)));
            })
            .withMessageMatching("가로 라인은 겹칠 수 없습니다");
    }

}
