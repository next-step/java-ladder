package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("Point 인스턴스가 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int position = 1;
        Direction pass = Direction.first(false);

        // when
        Point point = Point.from(position, pass);

        // then
        assertThat(point).isNotNull();
    }


    @DisplayName("Point 인스턴스가 오른쪽으로 이동하는지 테스트")
    @Test
    void 기능_오른쪽_이동() {
        // given
        int position = 1;
        int executed = 2;
        Direction right = Direction.first(true);

        // when
        Point point = Point.from(position, right);

        // then
        assertThat(point.move()).isEqualTo(executed);
    }

    @DisplayName("Point 인스턴스가 왼쪽으로 이동하는지 테스트")
    @Test
    void 기능_왼쪽_이동() {
        // given
        int position = 1;
        int executed = 0;
        Direction left = Direction.first(true).next(false);

        // when
        Point point = Point.from(position, left);

        // then
        assertThat(point.move()).isEqualTo(executed);
    }


    @DisplayName("Point 인스턴스가 그대로 아래로 이동하는지 테스트")
    @Test
    void 기능_아래로_이동() {
        // given
        int position = 1;
        int executed = 1;
        Direction pass = Direction.first(false);

        // when
        Point point = Point.from(position, pass);

        // then
        assertThat(point.move()).isEqualTo(executed);
    }


}