package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ladderBoardTest {
    @Test
    @DisplayName("사다리판 생성 테스트")
    void ladderBoardConstructTest() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(List.of(new Point(true),new Point(false),new Point(false))));
        lines.add(new Line(List.of(new Point(true),new Point(false),new Point(true))));
        lines.add(new Line(List.of(new Point(true),new Point(false),new Point(false))));
        lines.add(new Line(List.of(new Point(true),new Point(false),new Point(true))));
        LadderBoard ladderBoard = new LadderBoard(lines);
        assertThat(ladderBoard.getLadderBoard()).hasSize(lines.size());
    }

}
