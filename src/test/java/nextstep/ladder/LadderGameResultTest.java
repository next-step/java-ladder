package nextstep.ladder;

import java.util.List;
import nextstep.ladder.domain.LadderGameResult;
import nextstep.ladder.domain.Ladders;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Results;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameResultTest {

    Line firstLine = new Line();
    Line middleLine = Line.last();
    Line lastLine = Line.first();

    Lines line = new Lines(List.of(firstLine, middleLine, lastLine));

    Ladders ladders = new Ladders(1, List.of(line));

    Participants participants  = new Participants(List.of("pobi","woni","honux"));

    Results results = new Results(List.of("5000","꽝","1000"));

    /**
     *       pobi   woni   honux
     *           |      |-----|
     *         5000    꽝    1000
     */

    @Test
    @DisplayName("특정 참여자의 사다리 게임 결과를 가져온다")
    void 특정_참여자_결과_테스트() {
        LadderGameResult ladderGameResult = new LadderGameResult(ladders, participants, results);

        Assertions.assertThat(ladderGameResult.getSpecificPlayerResult("woni")).isEqualTo("1000");
        Assertions.assertThat(ladderGameResult.getSpecificPlayerResult("honux")).isEqualTo("꽝");
    }
}
