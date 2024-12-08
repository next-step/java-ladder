package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CrossTest {
    @DisplayName("현재 위치에서 이동한 위치 값을 반환한다.")
    @CsvSource({"false,true,2", "true,false,0", "false,false,1"})
    @ParameterizedTest(name = "이동전 Position=1, 왼쪽 Point={0}, 현재 Point={1}, 이동한 뒤 Position={2}")
    void move(boolean left, boolean current, int expected) {
        Cross cross = new Cross(1, Point.first(left), current);

        int actual = cross.move();

        assertThat(actual).isEqualTo(expected);
    }
}
