package camp.nextstep.edu.rebellion.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @DisplayName("최초 생성 시 mark 할 수 있는지 여부 확인")
    @Test
    public void canMarkTest() {
        // given
        Point point = new Point();

        // when & then
        assertThat(point.canMark()).isTrue();
    }

    @DisplayName("이전을 mark 했을 때 제대로 marking 되는지 확인")
    @Test
    public void markOnPrevTest() {
        // given
        Point point = new Point();

        // when
        point.markOnPrev();

        // then
        assertThat(point.hasPrev()).isTrue();
    }

    @DisplayName("다음을 mark 했을 때 제대로 marking 되는지 확인")
    @Test
    public void markOnNextTest() {
        // given
        Point point = new Point();

        // when
        point.markOnNext();

        // then
        assertThat(point.hasNext()).isTrue();
    }
}
