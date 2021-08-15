package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.ladder.Ladder;
import step2.domain.ladder.LadderLine;
import step2.domain.ladder.LadderPoint;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
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
            Arguments.arguments(Arrays.asList("a", "b", "c", "d", "e", "f"), 5)
        );
    }
}
