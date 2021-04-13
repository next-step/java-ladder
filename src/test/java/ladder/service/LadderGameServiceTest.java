package ladder.service;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        lines.add(new Line(Stream.of(true, false, true, false).map(Point::new).collect(Collectors.toList())));
        lines.add(new Line(Stream.of(false, true, false, false).map(Point::new).collect(Collectors.toList())));
        lines.add(new Line(Stream.of(true, false, false, false).map(Point::new).collect(Collectors.toList())));
        lines.add(new Line(Stream.of(false, true, false, false).map(Point::new).collect(Collectors.toList())));
        lines.add(new Line(Stream.of(true, false, true, false).map(Point::new).collect(Collectors.toList())));
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
        lines.add(new Line(Stream.of(true, false, true, false).map(Point::new).collect(Collectors.toList())));
        lines.add(new Line(Stream.of(false, true, false, false).map(Point::new).collect(Collectors.toList())));
        lines.add(new Line(Stream.of(true, false, false, false).map(Point::new).collect(Collectors.toList())));
        lines.add(new Line(Stream.of(false, true, false, false).map(Point::new).collect(Collectors.toList())));
        lines.add(new Line(Stream.of(true, false, true, false).map(Point::new).collect(Collectors.toList())));
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