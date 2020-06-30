package nextstep.study3;

import static org.assertj.core.api.Assertions.assertThat;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study3.domain.Direction;
import study3.domain.Point;

class PointTest {
	
	@Test
	@DisplayName("인덱스 검증 메소드")
    public void 우측으로_한칸움직이면_move의_인덱스가_하나늘어난다() {
        assertThat(new Point(0, new Direction(false, true)).move()).isEqualTo(1);
    }
	
	@Test
	@DisplayName("두번째 move가 제자리인 경우 인덱스 검증")
    public void next_stay() {
        Point second = new Point(0, new Direction(false, false)).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

	@Test
	@DisplayName("왼쪽으로 움직이면 인덱스가 하나떨어진다")
	public void next_left() {
	    Point second = new Point(0, new Direction(false, true)).next(FALSE);
	    assertThat(second.move()).isEqualTo(0);
	}
	
	@Test
	@DisplayName("오른쪽으로 움직였을떄 2가된다")
	public void next_right() {
	    Point second = new Point(0, new Direction(false, false)).next(TRUE);
	    assertThat(second.move()).isEqualTo(2);
	}
	
	@Test
	@DisplayName("right가 true이면 next는 false / 한라인에 두번이동불가")
	public void next() {
	    Point second = new Point(0, new Direction(false, true)).next();
	    assertThat(second.move()).isEqualTo(0);
	}
}
