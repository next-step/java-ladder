package nextstep.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.ladder.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @ParameterizedTest
    @DisplayName("LadderLine 생성 성공")
    @MethodSource("createLadder")
    public void createGame(List<String> names, int size) {
        //given
        LadderData ladderData = LadderData.of(names, size);

        //when, then
        Ladder ladder = ladderData.createLadder();
    }

    @ParameterizedTest
    @DisplayName("LadderLine 생성 성공")
    @MethodSource("createLadderFail")
    public void createGameFail(List<String> names, int size) {
        //given, when, then
        assertThatThrownBy(() -> {
            LadderData ladderData = LadderData.of(names, size);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @DisplayName("LadderLine 생성 성공")
    @CsvSource(value = {"1", "2", "3", "4", "5"})
    public void createLadderLine(int size) {
        //given, when, then
        LadderLine ladderLine = LadderLine.of(size);
    }

    @ParameterizedTest
    @DisplayName("LadderLine 생성 실패")
    @CsvSource(value = {"-1", "0", "6"})
    public void createLadderLineFail() {
        //given, when, then
        assertThatThrownBy(() -> {
            LadderLine ladderLine = LadderLine.of(-1);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @DisplayName("Ladder 생성 성공")
    @MethodSource("createLadder")
    public void createLadder(List<String> names, int size) {
        //given, when, then
        Ladder.create(names, size);
    }

    @ParameterizedTest
    @DisplayName("Ladder 생성 실패")
    @MethodSource("createLadderFail")
    public void createLadderFail(List<String> names, int size) {
        //given, when, then
        assertThatThrownBy(() -> {
            Ladder.create(names, size);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("LadderLine 검증")
    @RepeatedTest(50)
    public void validateLadderLine() {
        //given, when
        int size = new Random().nextInt(4) + 1;
        LadderLine ladderLine = LadderLine.of(size);
        int length = ladderLine.getLine()
            .size();

        //then
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                assertThat(ladderLine.getLine().get(i)).isNotEqualTo(LadderPoint.LEFT);
            } else if (i == length - 1) {
                assertThat(ladderLine.getLine().get(i)).isNotEqualTo(LadderPoint.RIGHT);
            } else if (ladderLine.getLine().get(i - 1) == LadderPoint.RIGHT) {
                assertThat(ladderLine.getLine().get(i)).isEqualTo(LadderPoint.LEFT);
            }
        }
    }

    @ParameterizedTest
    @DisplayName("참가자의 사다리 시작점 찾기")
    @MethodSource("createLadderForFindPosition")
    public void test01(List<String> names, int size, String name, int expected) {
        //given
        Ladder ladder = Ladder.create(names, size);

        //when
        int positionOf = ladder.findPositionOf(name);

        //then
        assertThat(positionOf).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("참가자의 사다리 시작점 찾기 실패")
    @MethodSource("createLadder")
    public void test01(List<String> names, int size) {
        //given
        String name = "wgonwoginqwbqwg";
        Ladder ladder = Ladder.create(names, size);

        //when, then
        assertThatThrownBy(() -> {
            ladder.findPositionOf(name);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @DisplayName("사다리에서 이동")
    @CsvSource(value = {"1:LEFT:0", "2:RIGHT:3", "3:NONE:3"}, delimiter = ':')
    public void moveLeft(int position, LadderPoint ladderPoint, int expected) {
        //given, when
        int move = ladderPoint.move(position);

        //then
        assertThat(move).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("사다리 결과 확인")
    @MethodSource("createResult")
    public void test01(List<String> results, int position, String expected) {
        //given
        Result result = Result.of(results);

        //when
        String resultOf = result.findResultOf(position);

        //then
        assertThat(resultOf).isEqualTo(expected);
    }

    static Stream<Arguments> createLadder() {
        return Stream.of(
            Arguments.arguments(Arrays.asList("a", "b", "c"), 5),
            Arguments.arguments(Arrays.asList("a", "b", "c", "d"), 10),
            Arguments.arguments(Arrays.asList("a", "b", "c", "d", "e"), 11),
            Arguments.arguments(Arrays.asList("a", "b"), 30)
        );
    }

    static Stream<Arguments> createLadderFail() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(), 5),
            Arguments.arguments(Arrays.asList("abcdefghj"), 5)
        );
    }

    public static Stream<Arguments> createLadderForFindPosition() {
        return Stream.of(
            Arguments.arguments(Arrays.asList("a", "b", "c"), 5, "a", 0),
            Arguments.arguments(Arrays.asList("a", "b", "c", "d"), 10, "c", 2),
            Arguments.arguments(Arrays.asList("a", "b", "c", "d", "e"), 11, "e", 4),
            Arguments.arguments(Arrays.asList("a", "b"), 30, "b", 1)
        );
    }

    static Stream<Arguments> createResult() {
        return Stream.of(
            Arguments.arguments(Arrays.asList("1000", "꽝", "5000", "꽝"), 3, "꽝"),
            Arguments.arguments(Arrays.asList("1000", "꽝", "5000", "꽝"), 0, "1000")
        );
    }
}
