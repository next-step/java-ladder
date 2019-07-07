package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        final List<Line> lines = new ArrayList<>();
        final List<Point> line1 = new ArrayList<>();
        Point first = Point.firstOf(b -> true);
        Point next1 = first.nextOf(b -> false);
        Point next2 = next1.nextOf(b -> true);
        Point end = next2.endOf();
        line1.add(first);
        line1.add(next1);
        line1.add(next2);
        line1.add(end);

        final List<Point> line2 = new ArrayList<>();
        first = Point.firstOf(b -> false);
        next1 = first.nextOf(b -> true);
        next2 = next1.nextOf(b -> false);
        end = next2.endOf();
        line2.add(first);
        line2.add(next1);
        line2.add(next2);
        line2.add(end);

        lines.add(new Line(line1));
        lines.add(new Line(line2));

        ladder = new Ladder(lines);
    }

    @Test
    @DisplayName("사다리는 높이와 참가자들의 수로 생성된다.")
    void new_WithHeightAndNumberOfParticipants_Created() {
        final int height = 5;
        final int numberOfParticipants = 7;
        final Ladder ladder = Ladder.generateRandom(height, numberOfParticipants);
        assertThat(ladder).isInstanceOf(Ladder.class);
    }

    @Test
    @DisplayName("사다리에서 얻은 Lines는 수정할 수 없다.")
    void getLines_Modify_ExceptionThrown() {
        final int height = 5;
        final int numberOfParticipants = 7;
        final Ladder ladder = Ladder.generateRandom(height, numberOfParticipants);
        final List<Line> lines = ladder.getLines();
        assertThatThrownBy(() -> lines.add(Line.generateRandom(numberOfParticipants)))
                .isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("사다리의 시작점에서 도착점을 계산할 수 있다.")
    void move_StartToEnd_result() {
        assertThat(ladder.move(0)).isEqualTo(2);
        assertThat(ladder.move(1)).isEqualTo(0);
        assertThat(ladder.move(2)).isEqualTo(3);
        assertThat(ladder.move(3)).isEqualTo(1);
    }
}
