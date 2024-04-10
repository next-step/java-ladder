package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.domain.ladder.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    @DisplayName("연결 여부를 반환하는 메소드 테스트")
    void IS_CONNECTED_TEST() {
        Point point = Point.of(true);
        assertThat(point.isConnected()).isEqualTo(true);

        point = Point.of(false);
        assertThat(point.isConnected()).isEqualTo(false);
    }

    @Test
    @DisplayName("연결 여부를 나타내는 Point 객체를 생성하는 테스트")
    void GENERATE_POINT_TEST() {
        assertThat(Point.generatePoint(() -> true).isConnected()).isEqualTo(true);
        assertThat(Point.generatePoint(() -> false).isConnected()).isEqualTo(false);
    }

}
