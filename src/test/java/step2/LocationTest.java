package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Line;
import step2.domain.Location;
import step2.domain.Point;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {

    @Test
    @DisplayName("왼쪽이 존재하는지")
    void leftExistTest() {
        Location location = new Location(true, false);
        assertThat(location.isLeft()).isEqualTo(true);
    }

    @Test
    @DisplayName("왼쪽이 존재하는지")
    void rightExistTest() {
        Location location = new Location(false, true);
        assertThat(location.isRight()).isEqualTo(true);
    }

    @Test
    @DisplayName("첫번째 포인트는 오른쪽으로만 갈 수 있는 테스트")
    void firstPointTest() {
        Location location = new Location(false, true);
        assertThat(location.first(true)).isEqualTo(new Location(false, true));
    }

    @Test
    @DisplayName("같은 가로 라인에서 연속으로 줄이 만들어질 수 없다.")
    void sameLineNotExist() {

        Assertions.assertThatThrownBy(() -> new Location(true,true))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
