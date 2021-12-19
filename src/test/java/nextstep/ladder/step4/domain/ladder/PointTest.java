package nextstep.ladder.step4.domain.ladder;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PointTest {

    @ParameterizedTest
    @CsvSource(value = {"1,0", "2,1", "5,4", "10,9"})
    @DisplayName("왼쪽 이동")
    void moveLeft(int index, int moveIndex) {
        assertThat(new Point(index, Direction.first(TRUE).last()).move()).isEqualTo(moveIndex);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "5,5", "10,10"})
    @DisplayName("정지")
    void moveStop(int index, int moveIndex) {
        assertThat(new Point(index, Direction.first(FALSE)).move()).isEqualTo(moveIndex);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,02", "2,3", "5,6", "10,11"})
    @DisplayName("오른쪽 이동")
    void moveRight(int index, int moveIndex) {
        assertThat(new Point(index, Direction.first(TRUE)).move()).isEqualTo(moveIndex);
    }

}
