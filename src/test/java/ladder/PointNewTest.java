package ladder;

import ladder.domain.DirectionNew;
import ladder.domain.PointNew;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointNewTest {
    @DisplayName("포인트 클래스는 인스턴스를 생성한다.")
    @Test
    void create() {
        assertThat(new PointNew(0, new DirectionNew(false, false)))
                .isEqualTo(new PointNew(0, new DirectionNew(false, false)));
    }

    @DisplayName("다음 포인트의 인덱스를 반환한다.")
    @Test
    void nextIndex() {
        PointNew pointNew = new PointNew(0, new DirectionNew(false, false));
        assertThat(pointNew.nextIndex()).isEqualTo(1);
    }

    @DisplayName("포인트가 오른쪽 방향을 가지고 있다면 true를 반환한다.")
    @Test
    void hasRightDirection() {
        PointNew pointNew = new PointNew(0, new DirectionNew(false, true));
        assertThat(pointNew.hasRightDirection()).isTrue();
    }

    @DisplayName("포인트가 왼쪽 방향을 가지고 있다면 true를 반환한다.")
    @Test
    void hasLeftDirection() {
        PointNew pointNew = new PointNew(0, new DirectionNew(true, false));
        assertThat(pointNew.hasLeftDirection()).isTrue();
    }

    @DisplayName("포인트가 왼쪽 또는 오른쪽 방향을 가지고 있다면 true를 반환한다.")
    @Test
    void hasDirection() {
        PointNew pointNew1 = new PointNew(0, new DirectionNew(false, true));
        PointNew pointNew2 = new PointNew(0, new DirectionNew(true, false));

        assertThat(pointNew1.hasDirection()).isTrue();
        assertThat(pointNew2.hasDirection()).isTrue();
    }

    @DisplayName("포인트가 움직인 후의 결과 인덱스를 반환한다.")
    @Test
    void move() {
        PointNew pointNew1 = new PointNew(1, new DirectionNew(false, true));
        PointNew pointNew2 = new PointNew(1, new DirectionNew(true, false));
        PointNew pointNew3 = new PointNew(1, new DirectionNew(false, false));

        assertThat(pointNew1.move()).isEqualTo(2);
        assertThat(pointNew2.move()).isEqualTo(0);
        assertThat(pointNew3.move()).isEqualTo(1);
    }
}
