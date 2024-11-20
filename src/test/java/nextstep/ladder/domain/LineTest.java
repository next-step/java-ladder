package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void 다리_포인트가_존재하는_경우_스왑된다() {
        Line line = new Line(true, 0);

        Position position = new Position(Map.of(0, 0, 1, 1));
        line.move(position);

        assertThat(position).isEqualTo(new Position(Map.of(0, 1, 1, 0)));
    }

    @Test
    void 다리의_포인트가_없으면_스왑되지않는다() {
        Line line = new Line(false, 0);

        Position position = new Position(Map.of(0, 0, 1, 1));
        line.move(position);

        assertThat(position).isEqualTo(new Position(Map.of(0, 0, 1, 1)));
    }

}
