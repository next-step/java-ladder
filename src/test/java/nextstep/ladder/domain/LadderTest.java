package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("Ladder 생성시, 전달한 갯수만큼 lines 생성되어야 한다.")
    void createHeightSizeTest() {
        Ladder ladder = Ladder.create(PositiveNumber.create(5), 10);

        List<Line> lines = ladder.getLines();

        assertThat(lines).hasSize(5);
        assertThat(lines.get(0).getPoints()).hasSize(9);
        System.out.println(ladder);
    }

    @Test
    @DisplayName("Ladder 생성시, 생성되는 각 Line의 갯수는, 참가자의 수 -1 이다.")
    void createLineInPointSizeTest() {

        int participantsCount = 10;
        Ladder ladder = Ladder.create(PositiveNumber.create(5), participantsCount);

        List<Line> lines = ladder.getLines();

        assertThat(lines.get(0).getPoints()).hasSize(participantsCount - 1);
    }
}
