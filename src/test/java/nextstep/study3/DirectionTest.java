package nextstep.study3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import study3.domain.Direction;

class DirectionTest {

	@Test
	@DisplayName("디렉션이 같으면 같은 Direction이다.")
    public void 기본적인_비교_메소드() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }
	
	@Test
	@DisplayName("Direction이 둘다 true일수 없다.")
    public void 디렉션이_둘다_트루이면_말이안된다() {
		assertThatThrownBy(() ->Direction.of(TRUE, TRUE))
		.isInstanceOf(IllegalStateException.class);
    }
	
	@Test
	@DisplayName("이전의 right는 다음의 left와 같다.")
    public void 이전의_right는_다음의_left와_같다() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }
}
