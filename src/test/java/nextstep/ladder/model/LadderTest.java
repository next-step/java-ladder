package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LadderTest {

    private Participants participants;
    private Lines lines;

    @BeforeEach
    public void setup() {
        List<Bridge> bridges = List.of(Bridge.of(true));
        List<Line> line = List.of(new Line(2, bridges));

        participants = new Participants("a,b");
        lines = new Lines(line);
    }

    @Test
    public void generatorLines_높이가_0일때_에러_테스트() {
        assertThatThrownBy( () -> new Ladder(participants, lines, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
