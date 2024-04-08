package nextstep.ladder;

import nextstep.ladder.domain.LadderBoard;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
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
        lines.add(Line.from((List.of(true, false, true))));
        lines.add(Line.from((List.of(true, false, true))));
        lines.add(Line.from((List.of(true, false, false))));
        lines.add(Line.from((List.of(true, false, true))));
        LadderBoard ladderBoard = new LadderBoard(lines);
        assertThat(ladderBoard.getLadderBoard()).hasSize(lines.size());
    }

}
