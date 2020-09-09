package ladder.domain;

import ladder.domain.line.Line;
import ladder.domain.line.LineStrategy;
import ladder.domain.line.SteppingStoneManualLine;
import ladder.domain.line.SteppingStoneOthersideLine;
import ladder.view.PrintResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LadderResultTest {

    private static List<Line> lines = setLine();
    private static  List<Line> setLine() {
        List<Line> linesValue =new ArrayList<>();
        LineStrategy steppingStoneManualLine = new SteppingStoneManualLine();
        LineStrategy steppingStoneOthersideLine = new SteppingStoneOthersideLine();
        Line line = Line.of(4, steppingStoneManualLine);
        Line line1 = Line.of(4, steppingStoneOthersideLine);
        Line line2 = Line.of(4, steppingStoneManualLine);
        Line line3 = Line.of(4, steppingStoneOthersideLine);
        Line line4 = Line.of(4, steppingStoneManualLine);
        linesValue.add(line);
        linesValue.add(line1);
        linesValue.add(line2);
        linesValue.add(line3);
        linesValue.add(line4);
        return linesValue;
    }
    private static List<GamePerson> people = Arrays.stream(StringSplit.splitWithDelimiter("test1, test2, test3, test4"))
            .map(GamePerson::new)
            .collect(Collectors.toList());
    private static List<String> gameReult = Arrays.stream(StringSplit.splitWithDelimiter("꽝,5000,꽝,3000"))
            .collect(Collectors.toList());
    private static Ladder ladder = Ladder.of2(lines, 4);
    private static LadderGame ladderGame = LadderGame.of2(people, ladder);
    private static LadderResult ladderResult = new LadderResult(gameReult, ladderGame);




    @DisplayName("사람이 해당 결과에 없을 경우 IllegerArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"test3434", "test1212d", "tesdt3", "testd4", "teddst"})
    public void getPersonLocaiontNoPerson(String target) {

        LadderResult ladderResult = new LadderResult(gameReult, ladderGame);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ladderResult.getPersonLocation(target));
    }



    @DisplayName("게임 결과 테스트")
    @ParameterizedTest
    @MethodSource("getResultArgument")
    public void getResultTest( LadderResult ladderResult, String name, String result) {
        System.out.println(name);
        PrintResult.printNames(ladderGame.getPeople());
        PrintResult.makeLadder(ladder);
        PrintResult.printResults(gameReult);
        assertThat(ladderResult.getPersonResult(name)).isEqualTo(result);
    }

    private static Stream<Arguments> getResultArgument() {
        return Stream.of(
                Arguments.of(ladderResult,people.get(0).getName(), gameReult.get(2)),
                Arguments.of(ladderResult,people.get(1).getName(), gameReult.get(3)),
                Arguments.of(ladderResult,people.get(2).getName(), gameReult.get(0)),
                Arguments.of(ladderResult,people.get(3).getName(), gameReult.get(1))
        );
    }

}
