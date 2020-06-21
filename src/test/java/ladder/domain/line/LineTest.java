package ladder.domain.line;

import ladder.domain.point.Point;
import ladder.domain.point.RandomPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @DisplayName("플레이어 숫자가 2보다 작으면 예외 발생")
    @Test
    void createInvalidPlayer() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.create(1, new RandomPointGenerator()));
    }

    @DisplayName("point generator가 null이면 예외 발생")
    @Test
    void createNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.create(2, null));
    }

    @DisplayName("입력 플레이어 수만큼 point를 생성 반환")
    @Test
    void getLengths() {
        Line line = Line.create(10, new RandomPointGenerator());

        assertThat(line.getLengths()).hasSize(10);
    }

    @DisplayName("첫번쨰 포인트 개수는 포인트 생성기와 상관 없이 무조건 0")
    @Test
    void getLengthsFirstIndex() {
        Line line = Line.create(10, Point::five);

        assertThat(line.getLengths().get(0)).isEqualTo(0);
    }

    @DisplayName("포인트가 모두 존재하지 않는 경우")
    @Test
    void getLengthsZero() {
        Line line = Line.create(10, Point::zero);
        List<Integer> lenghts = line.getLengths();
        lenghts.remove(0);
        lenghts.forEach(length -> assertThat(length).isEqualTo(0));
    }

    @DisplayName("포인트가 모두 존재하는 경우")
    @Test
    void getLengthsFive() {
        Line line = Line.create(10, Point::five);
        List<Integer> lenghts = line.getLengths();
        lenghts.remove(0);
        lenghts.forEach(length -> assertThat(length).isEqualTo(5));
    }
}
