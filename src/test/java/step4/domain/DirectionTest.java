package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {

    @Test
    void 방향을_생성한다() {
        //given
        Direction direction = Direction.of(true, false);
        //when
        //then
        assertThat(direction).isEqualTo(Direction.of(true, false));
    }

    @Test
    void 방향_왼쪽과_현재가_연결되면_IllegalArgumentException이_발생한다() {
        //given
        //when
        //then
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시작_방향을_생성한다() {
        //given
        Direction direction = Direction.start(Boolean.TRUE);
        //when

        //then
        assertThat(direction.isLeft()).isFalse();
        assertThat(direction.isRight()).isTrue();
    }

    @Test
    void 시작_다음_방향을_생성한다() {
        //given
        Direction direction = Direction.start(Boolean.TRUE).next(Boolean.FALSE);
        //when

        //then
        assertThat(direction.isLeft()).isTrue();
        assertThat(direction.isRight()).isFalse();
    }

    @Test
    void 마지막_방향을_생성한다() {
        //given
        Direction direction = Direction.start(Boolean.TRUE)
                .next(Boolean.FALSE)
                .last();
        //when

        //then
        assertThat(direction.isLeft()).isFalse();
        assertThat(direction.isRight()).isFalse();
    }
}
