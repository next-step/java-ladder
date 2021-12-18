package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("play 메소드 호출 시 index를 input으로 넣어주면 play된 index를 반환")
    public void playTest() {
        Line lineA = Line.ofString("right,left,right,left,none,none");
        Line lineB = Line.ofString("none,none,right,left,right,left");
        Line lineC = Line.ofString("none,right,left,right,left,none");
        Line lineD = Line.ofString("right,left,none,none,right,left");
        List<Line> lines = new ArrayList<>();
        lines.add(lineA);
        lines.add(lineB);
        lines.add(lineC);
        lines.add(lineD);
        Ladder ladder = Ladder.ofLines(lines);
        assertThat(ladder.play(0)).isEqualTo(2);
        assertThat(ladder.play(1)).isEqualTo(1);
        assertThat(ladder.play(3)).isEqualTo(5);
        assertThat(ladder.play(2)).isEqualTo(0);
        assertThat(ladder.play(5)).isEqualTo(3);
    }
}
