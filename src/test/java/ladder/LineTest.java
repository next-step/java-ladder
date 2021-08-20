package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @Test
    void 사다리_게임에_참여하는_입력값이_주어진다면_해당_인원_수_만큼_Line객체를_생성한다() {
        int countOfPerson = 4;
        Line line = Line.from(countOfPerson);
        assertThat(line).isInstanceOf(Line.class);
        assertThat(line.toList().size()).isEqualTo(countOfPerson);
    }

    @Test
    void 사다리_게임에_참여하는_인원수가_1명_이하이면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            Line.from(1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
