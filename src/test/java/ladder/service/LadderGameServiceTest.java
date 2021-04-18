package ladder.service;

import ladder.domain.*;
import ladder.service.dto.LadderGameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameServiceTest {

    @Test
    @DisplayName("사다리게임 결과 리스트 조회")
    void inquiryGameResults() {
        // given
        List<String> expectedList = Arrays.asList("꽝", "3000", "꽝", "5000");
        LadderGameService service = new LadderGameService();

        Participants participants = new Participants("pobi,honux,crong,jk");
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, true)),
                new Point(1, new Direction(true, false)),
                new Point(2, new Direction(false, true)),
                new Point(3, new Direction(true, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, false)),
                new Point(1, new Direction(false, true)),
                new Point(2, new Direction(true, false)),
                new Point(3, new Direction(false, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, true)),
                new Point(1, new Direction(true, false)),
                new Point(2, new Direction(false, false)),
                new Point(3, new Direction(false, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, false)),
                new Point(1, new Direction(false, true)),
                new Point(2, new Direction(true, false)),
                new Point(3, new Direction(false, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, true)),
                new Point(1, new Direction(true, false)),
                new Point(2, new Direction(false, true)),
                new Point(3, new Direction(true, false))
        )));
        Ladder ladder = new Ladder(lines);
        MatchingItems matchingItems = new MatchingItems("꽝,5000,꽝,3000", participants.getCount());

        // when
        List<LadderGameResult> gameResults = service.executeGame(participants, ladder, matchingItems);

        // then
        for (int i = 0; i < expectedList.size(); i++) {
            assertThat(expectedList.get(i)).isEqualTo(gameResults.get(i).getGameResult());
        }
    }

    @Test
    @DisplayName("사다리게임 실행결과는 수정 불가능")
    void gameResultsIsUnmodifiable() {
        // given
        List<String> expectedList = Arrays.asList("꽝", "3000", "꽝", "5000");
        LadderGameService service = new LadderGameService();

        Participants participants = new Participants("pobi,honux,crong,jk");
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, true)),
                new Point(1, new Direction(true, false)),
                new Point(2, new Direction(false, true)),
                new Point(3, new Direction(true, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, false)),
                new Point(1, new Direction(false, true)),
                new Point(2, new Direction(true, false)),
                new Point(3, new Direction(false, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, true)),
                new Point(1, new Direction(true, false)),
                new Point(2, new Direction(false, false)),
                new Point(3, new Direction(false, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, false)),
                new Point(1, new Direction(false, true)),
                new Point(2, new Direction(true, false)),
                new Point(3, new Direction(false, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, true)),
                new Point(1, new Direction(true, false)),
                new Point(2, new Direction(false, true)),
                new Point(3, new Direction(true, false))
        )));
        Ladder ladder = new Ladder(lines);
        MatchingItems matchingItems = new MatchingItems("꽝,5000,꽝,3000", participants.getCount());

        // when
        List<LadderGameResult> gameResults = service.executeGame(participants, ladder, matchingItems);

        // then
        assertThrows(UnsupportedOperationException.class, () -> gameResults.add(new LadderGameResult("test", "1000")));
        assertThrows(UnsupportedOperationException.class, () -> gameResults.remove(0));
    }
}