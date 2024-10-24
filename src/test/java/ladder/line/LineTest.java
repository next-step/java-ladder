package ladder.line;

import ladder.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {

    @DisplayName("6명 사이에서 사다리 라인 5개를 만들 수 있다.")
    @Test
    void createThreeLine() {
        Line line = new Line(6, () -> true);

        assertThat(line).isEqualTo(new Line(List.of(true, false, true, false, true)));
    }


    @DisplayName("사다리가 연결 되어있으면 이동할 수 있다.")
    @Test
    void move() {
        Line line = new Line(3, () -> true);

        Position moveIndex0 = line.move(0);
        Position moveIndex1 = line.move(1);
        Position moveIndex2 = line.move(2);

        assertAll(
                () -> assertThat(moveIndex0).isEqualTo(new Position(1)),
                () -> assertThat(moveIndex1).isEqualTo(new Position(0)),
                () -> assertThat(moveIndex2).isEqualTo(new Position(2))
        );
    }


}
