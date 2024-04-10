package nextstep.ladder;

import nextstep.ladder.domain.ladder.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    @DisplayName("연결 여부를 반환하는 메소드 테스트")
    void IS_CONNECTED_TEST() {
        Point point = Point.of(true);
        Assertions.assertThat(point.isConnected()).isEqualTo(true);

        point = Point.of(false);
        Assertions.assertThat(point.isConnected()).isEqualTo(false);
    }

}
