package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    void 위치를_생성한다() {
        //given
        Position position = Position.of(1);
        //when

        //then
        assertThat(position).isEqualTo(Position.of(1));
    }

    @Test
    void 위치를_왼쪽으로_이동한다() {
        //given
        Position position = Position.of(1);
        //when
        position.moveLeft();
        //then
        assertThat(position.position()).isEqualTo(0);
    }

    @Test
    void 위치가_0일때_왼쪽으로_이동하면_IllegalArgumentException_이_발생한다() {
        //given
        Position position = Position.of(0);
        //when & then
        assertThatThrownBy(position::moveLeft)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 위치를_오른쪽으로_이동한다() {
        //given
        Position position = Position.of(0);
        //when
        position.moveRight();
        //then
        assertThat(position.position()).isEqualTo(1);
    }
}
