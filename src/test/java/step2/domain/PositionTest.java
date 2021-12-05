package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    void 위치를_생성한다() {
        //given
        Position position = Position.of(6);
        //when
        //then
        assertThat(position).isEqualTo(Position.of(6));
    }

    @Test
    void 위치를_전진한다() {
        //given
        Position position = Position.of(6);
        //when
        position.moveFront();
        //then
        assertThat(position.position()).isEqualTo(7);
    }

    @Test
    void 위치를_후퇴한다() {
        //given
        Position position = Position.of(6);
        //when
        position.moveBack();
        //then
        assertThat(position.position()).isEqualTo(5);
    }

    @Test
    void 위치가_0에서_후퇴하면_IllegalArgumentException_이_발생한다() {
        //given
        Position position = Position.of(0);
        //when & then
        assertThatThrownBy(position::moveBack)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
