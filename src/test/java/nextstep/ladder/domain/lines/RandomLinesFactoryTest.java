package nextstep.ladder.domain.lines;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLinesFactoryTest {

    @Test
    @DisplayName("랜덤 사다리를 생성한다.")
    void create_random_lines() {
        // given
        int height = 4;
        int participantCount = 3;

        // when
        RandomLinesFactory randomLinesFactory = new RandomLinesFactory(
                height1 -> new Line(List.of(false, true, false, true)),
                (beforLine, height12) -> new Line(List.of(false, false, false, false)));
        Lines result = randomLinesFactory.createLines(height, participantCount);

        // then
        assertThat(result).isEqualTo(createExpectedLines());
    }

    private Lines createExpectedLines() {
        return new Lines(
                List.of(
                        new Line(List.of(false, true, false, true)),
                        new Line(List.of(false, false, false, false)),
                        new Line(List.of(false, false, false, false)
                        )
                ));
    }
}