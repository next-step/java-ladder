package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import ladder.domain.Line;

class LineTest {

    @Test
    void 사다리_게임에_참여하는_입력값이_주어진다면_해당_인원_수_만큼_Line객체를_생성한다() {
        List<String> persons = Arrays.asList("pobi", "honux", "crong", "jk");
        Line line = Line.from(persons.size());
        assertThat(line).isInstanceOf(Line.class);
        assertThat(line.toList().size()).isEqualTo(persons.size());
    }

    @Test
    void 중간다리가_연속적으로_두_개가_있으면_둘_중_하나는_제거한다() {
        Line line = Line.from(Arrays.asList(true, true, false, false));
        assertThat(line.toList().stream().filter(e -> e.equals(true)).count()).isEqualTo(1);
    }

    @Test
    void 마지막_라인은_중간다리여부가_참이면_거짓으로_변경하고_마지막_라인을_제외한_라인에_중간다리_하나를_생성한다() {
        Line line = Line.from(Arrays.asList(false, false, false, true));
        assertThat(line.toList().get(line.toList().size() - 1)).isFalse();
        assertThat(line.toList().stream().filter(e -> e.equals(true)).count()).isEqualTo(1);
    }
}
