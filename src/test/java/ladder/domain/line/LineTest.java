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
    void getConnects() {
        Line line = Line.create(10, new RandomPointGenerator());

        assertThat(line.getConnects()).hasSize(10);
    }

    @DisplayName("첫번쨰 포인트는 연결되지 않음")
    @Test
    void getConnectsFirstIndex() {
        Line line = Line.create(10, Point::connect);

        assertThat(line.getConnects().get(0)).isFalse();
    }

    @DisplayName("포인트가 모두 연결되지 않는 경우")
    @Test
    void connectAll() {
        Line line = Line.create(10, Point::disconnect);
        List<Boolean> connects = line.getConnects();
        connects.remove(0);
        connects.forEach(isConnect -> assertThat(isConnect).isFalse());
    }

    @DisplayName("포인트가 모두 연결된 경우")
    @Test
    void disconnectAll() {
        Line line = Line.create(10, Point::connect);
        List<Boolean> connects = line.getConnects();
        connects.remove(0);
        connects.forEach(isConnect -> assertThat(isConnect).isTrue());
    }
}
