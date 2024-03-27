package ladder.domain;

import static ladder.domain.Link.LEFT_LINK;
import static ladder.domain.Link.RIGHT_LINK;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("유효하다면 성공적으로 생성된다")
    void success() {
        List<Link> input = List.of(RIGHT_LINK, LEFT_LINK);
        assertThatNoException()
            .isThrownBy(() -> Line.from(input));
    }

    @Test
    @DisplayName("양방향 Link의 정합성이 훼손되면 예외가 발생한다")
    void fail_for_overlap() {
        List<Link> input = List.of(RIGHT_LINK, RIGHT_LINK);
        assertThatThrownBy(() -> Line.from(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Link가 없는 것을 link하면 예외가 발생한다")
    void fail_for_participant_column_true() {
        List<Link> input = List.of(LEFT_LINK);
        assertThatThrownBy(() -> Line.from(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Link가 빈 경우 예외가 발생한다")
    void fail_for_min_length_3() {
        List<Link> input = List.of();
        assertThatThrownBy(() -> Line.from(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
