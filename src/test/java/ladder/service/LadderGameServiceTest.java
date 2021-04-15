package ladder.service;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameServiceTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi:꽝", "honux:3000", "crong:꽝", "jk:5000"}, delimiter = ':')
    @DisplayName("사다리게임 결과 조회 - 단건조회")
    void inquiryGameResult(String participantName, String gameResult) {
        // given
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
        GameResults gameResults = new GameResults("꽝,5000,꽝,3000", participants.getCount());

        // when
        String inquiryGameResult = service.inquiryGameResult(participants, ladder, gameResults, participantName);

        // then
        assertThat(gameResult).isEqualTo(inquiryGameResult);
    }

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
        GameResults gameResults = new GameResults("꽝,5000,꽝,3000", participants.getCount());

        // when
        List<String> inquiryGameResults = service.inquiryGameResults(participants, ladder, gameResults);

        // then
        for (int i = 0; i < expectedList.size(); i++) {
            assertThat(expectedList.get(i)).isEqualTo(inquiryGameResults.get(i));
        }
    }
}