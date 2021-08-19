package ladder.domain.ladder;

import ladder.domain.line.Line;
import ladder.domain.line.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @Test
    @DisplayName("객체 생성")
    void construct() throws Exception {
        //given
        String namesOfPlayers = "god,pro,semi,ama";
        String namesOfAwards = "fail,5000,fail,3000";
        int ladderHeight = 5;

        Ladder ladder = Ladder.of(namesOfPlayers, ladderHeight);

        //when
        LadderResult ladderResult = LadderResult.of(ladder, namesOfAwards);

        //then
        assertThat(ladderResult).isEqualTo(LadderResult.of(ladder, namesOfAwards));

    }

    @ParameterizedTest(name = "한 명의 결과 {index} [{arguments}]")
    @MethodSource
    @DisplayName("한명의 결과")
    void result_of_player(String playersName, String resultsName, List<Boolean> lineList, String winnerPlayerName, String expected) throws Exception {
        //given
        Line line = Line.of(lineList);
        Lines lines = Lines.of(Arrays.asList(line));
        Ladder ladder = Ladder.of(playersName, lines);

        //when
        LadderResult ladderResult = LadderResult.of(ladder, resultsName);
        String actual = ladderResult.resultOfPlayer(winnerPlayerName);

        //then
        assertThat(actual).isEqualTo(expected);

    }

    private static Stream<Arguments> result_of_player() {
        return Stream.of(
                Arguments.of("pro,ama", "fail,5000", Arrays.asList(true), "pro", "5000"),
                Arguments.of("pro,ama", "fail,5000", Arrays.asList(true), "ama", "fail")
                ,
                Arguments.of("pro,ama", "fail,5000", Arrays.asList(false), "pro", "fail"),
                Arguments.of("pro,ama", "fail,5000", Arrays.asList(false), "ama", "5000")
                ,
                Arguments.of("pro,semi,ama", "1000,fail,5000", Arrays.asList(true, false), "pro", "fail"),
                Arguments.of("pro,semi,ama", "1000,fail,5000", Arrays.asList(true, false), "semi", "1000"),
                Arguments.of("pro,semi,ama", "1000,fail,5000", Arrays.asList(true, false), "ama", "5000")
                ,
                Arguments.of("pro,semi,ama", "1000,fail,5000", Arrays.asList(false, true), "pro", "1000"),
                Arguments.of("pro,semi,ama", "1000,fail,5000", Arrays.asList(false, true), "semi", "5000"),
                Arguments.of("pro,semi,ama", "1000,fail,5000", Arrays.asList(false, true), "ama", "fail")
        );
    }

    /*
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
     */
    @Test
    @DisplayName("전체 결과")
    void results() throws Exception {
        //given
        String namesOfPlayers = "god,pro,semi,ama";
        String namesOfAwards = "fail,5000,fail,3000";

        Lines lines = Lines.of(Arrays.asList(
                Line.of(true, false, true),
                Line.of(false, true, false),
                Line.of(true, false, false)
        ));
        Ladder ladder = Ladder.of(namesOfPlayers, lines);
        LadderResult ladderResult = LadderResult.of(ladder, namesOfAwards);

        //when
        Map<String, String> results = ladderResult.getResults();

        //then
        assertThat(results).containsEntry("god", "fail")
                .containsEntry("pro", "5000")
                .containsEntry("semi", "3000")
                .containsEntry("ama", "fail");
    }

}