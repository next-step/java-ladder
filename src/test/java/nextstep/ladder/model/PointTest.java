package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class PointTest {
    private Point point;

    @BeforeEach
    void setUp() {
        point = Point.first(true);
    }
    
    @DisplayName("point의 Direction 왼쪽 값 체크")
    @Test
    void directionLeftTest() {
        assertThat(point.showLeft()).isEqualTo(false);
    }
    
    @DisplayName("point의 Direction 오른쪽 값 체크")
    @Test
    void directionRightTest() {
        assertThat(point.showRight()).isEqualTo(true);
    }

    @DisplayName("위치 0 = {false,true}의 상태에서 true 쪽으로 한 칸 이동")
    @Test
    void moveTest() {
        assertThat(point.move()).isEqualTo(1);
    }

    @DisplayName("{true,false}인 Point 생성")
    @Test
    void nextTest() {
        assertThat(point.next(false)).isEqualTo(new Point(1, Direction.of(true,  false)));
    }

    @DisplayName("{true,true}인 Point 생성 시 예외발생")
    @Test
    void both_true_Exception() {
    	assertThatIllegalStateException().isThrownBy(() -> point.next(true));
    }
}
