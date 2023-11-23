package ladder;

import ladder.domain.Ladder;
import ladder.domain.Row;
import ladder.exception.InvalidColSizeException;
import ladder.exception.LineDuplicateException;
import ladder.factory.RandomRowStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class RowTest {

    @Test
    @DisplayName("열 개수가 2개 이하일 경우 에러 발생한다")
    public void col_minimum() {
        assertThatExceptionOfType(InvalidColSizeException.class)
            .isThrownBy(() -> {
                new Ladder(new RandomRowStrategy(5, 1));
            })
            .withMessageMatching("열 최소 개수를 만족하지 않습니다");
    }

    @Test
    @DisplayName("가로 라인이 겹칠 경우 에러 발생한다")
    public void line_duplicate() {
        assertThatExceptionOfType(LineDuplicateException.class)
            .isThrownBy(() -> {
                new Row(Arrays.asList(false, true, true));
            })
            .withMessageMatching("가로 라인은 겹칠 수 없습니다");
    }

    @Test
    @DisplayName("행에서 이동가능한 위치를 확인할 수 있다")
    public void row_available() {
        assertThat(new Row(Arrays.asList(true, false, false)).movable(0)).isTrue();
    }

}
