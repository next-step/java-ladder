package refactor;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import refactor.domain.*;
import refactor.domain.pointGenerate.SteppingStoneOthersidePoint;
import refactor.domain.pointGenerate.PointStrategy;
import refactor.domain.pointGenerate.SteppingStoneManualPoint;
import refactor.util.StringSplitUtil;
import refactor.view.PrintResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderResultTest {

    private static final int sizeOfPersonValue = 4;
    private static List<LadderLine> ladderLines = setLadderLines();
    private static List<LadderLine> setLadderLines() {
        List<LadderLine> ladderLinesValue = new ArrayList<>();
        PointStrategy trueStrategy = new SteppingStoneManualPoint();
        LadderLine line1 = LadderLine.init(sizeOfPersonValue, trueStrategy);
        LadderLine line2 = LadderLine.init(sizeOfPersonValue, new SteppingStoneOthersidePoint());
        LadderLine line3 = LadderLine.init(sizeOfPersonValue, trueStrategy);
        LadderLine line4 = LadderLine.init(sizeOfPersonValue, new SteppingStoneOthersidePoint());
        LadderLine line5 = LadderLine.init(sizeOfPersonValue, trueStrategy);

        ladderLinesValue.add(line1);
        ladderLinesValue.add(line2);
        ladderLinesValue.add(line3);
        ladderLinesValue.add(line4);
        ladderLinesValue.add(line5);

        return ladderLinesValue;
    }

    private static List<GamePerson> people = Arrays.stream(StringSplitUtil.splitWithDelimiter("test1, test2, test3, test4"))
            .map(GamePerson::new)
            .collect(Collectors.toList());
    private static List<String> gameReult = Arrays.stream(StringSplitUtil.splitWithDelimiter("꽝,5000,꽝,3000"))
            .collect(Collectors.toList());

    private static Ladder ladder = new Ladder(ladderLines);
    private static LadderGame ladderGame = LadderGame.of(people,ladder);
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
    public void getResultTest(LadderResult ladderResult, String name, String result) {
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
