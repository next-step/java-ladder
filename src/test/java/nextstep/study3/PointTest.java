package nextstep.study3;

import static org.assertj.core.api.Assertions.assertThat;
import static java.lang.Boolean.FALSE;
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
    public void next_stay() {
        Point second = new Point(0, new Direction(false, false)).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

	/*@Test
	public void next_left() {
	    Point second = Point.first(TRUE).next(FALSE);
	    assertThat(second.move(), is(0));
	}
	
	@Test
	public void next_right() {
	    Point second = Point.first(FALSE).next(TRUE);
	    assertThat(second.move(), is(2));
	}
	
	@Test
	public void next() {
	    Point second = Point.first(TRUE).next();
	    assertThat(second.move(), is(0));
	}*/
}
