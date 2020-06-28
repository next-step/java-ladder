package nextstep.study3;

import static org.assertj.core.api.Assertions.assertThat;
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
	
}
