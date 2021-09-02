package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@SuppressWarnings("NonAsciiCharacters")
public class DirectionTest {

    @Test
    public void 첫_위치의_Direction을_생성할_수_있다() {
        //given
        //when
        Direction direction = Direction.start(() -> false);
        //then
        assertThat(direction).isEqualTo(Direction.start(() -> false));
    }

    @Test
    public void 현재위치의_Direction이_오른쪽이면_다음위치의_Direction을_생성_시_left는_true이며_right는_false가_된다() {
        //given
        Direction direction = Direction.start(() -> true);
        //when
        Direction nextDirection = direction.next();
        //then
        assertThat(nextDirection.isLeft()).isTrue();
        assertThat(nextDirection.isRight()).isFalse();
    }

    @Test
    public void 현재위치의_Direction이_오른쪽이_아니면_다음위치의_Direction을_생성_시_left는_false이다() {
        //given
        Direction direction = Direction.start(() -> false);
        //when
        Direction nextDirection = direction.next();
        //then
        assertThat(nextDirection.isLeft()).isFalse();
    }

    @Test
    public void 양_방향에_대해_true를_가질_시_익셉션이_발생한다(){
        //given
        //when
        //then
        assertThatThrownBy(() -> Direction.create(true, true))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("사다리는 양쪽으로 이동할 수 없습니다");
    }
}
