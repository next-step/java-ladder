package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
class LocationTest {

    @Test
    public void 위치값을_받아서_위치를_만들_수_있다() {
        //given
        //when
        //then
        assertThat(Location.at(0)).isEqualTo(Location.at(0));
    }

    @Test
    public void 위치는_0보다_작으면_익셉션이_발생한다() {
        //given
        //when
        //then
        assertThatThrownBy(() -> Location.at(-1))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("위치는 0보다 작을 수 없습니다.");
    }

    @Test
    public void 위치를_왼쪽으로_옮길_수_있다() {
        //given
        //when
        //then
        assertThat(Location.at(1).toLeft()).isEqualTo(Location.at(0));
    }

    @Test
    public void 위치를_오른쪽으로_올길때_위치가_음수이면_익셉션이_발생한다() {
        //given
        //when
        //then
        assertThatThrownBy(() -> Location.at(0).toLeft())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("왼쪽으로 이동할 수 없습니다.");
    }

    @Test
    public void 위치를_오른쪽으로_옮길_수_있다() {
        //given
        //when
        //then
        assertThat(Location.at(1).toRight()).isEqualTo(Location.at(2));
    }
}