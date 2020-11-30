package step04.domain;

import exception.InvalidCountOfStepsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import strategy.PointStrategy;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderTest {
    NamesOfParticipant participants;
    PointStrategy pointStrategy;
    int countOfParticipants;

    @BeforeEach
    void setup() {
        participants = NamesOfParticipant.of("pobi,honux,crong,jk");
        countOfParticipants = participants.size();
        pointStrategy = () -> true;
    }

    @DisplayName("생성자")
    @Test
    void test_constructor_of() {
        assertThat(Ladder.of(1, countOfParticipants, pointStrategy))
                .isEqualTo(Ladder.of(1, countOfParticipants, pointStrategy));
    }

    private static Stream<Integer> provideInvalidCountOfLadderResult() {
        return Stream.of(-1, 0);
    }

    @DisplayName("Ladder 가 1 이상이 아니면 예외 처리")
    @ParameterizedTest
    @MethodSource("provideInvalidCountOfLadderResult")
    void test_validate(int countOfLadder) {
        assertThatExceptionOfType(InvalidCountOfStepsException.class)
                .isThrownBy(() -> Ladder.of(countOfLadder, countOfParticipants, pointStrategy));
    }

    @DisplayName("출력을 위한 기능")
    @Test
    void test_getLadder() {
        assertThat(Ladder.of(2, countOfParticipants, pointStrategy).getLadder())
                .isEqualTo(Arrays.asList(
                        Step.of(Arrays.asList(true, false, true)),
                        Step.of(Arrays.asList(true, false, true)))
                );
    }

    @Test
    void test_matchTable() {
        Ladder ladder = Ladder.of(1, countOfParticipants, pointStrategy);
        assertThat(ladder.matchTable())
                .isEqualTo(TableOfResult.of(Arrays.asList(1, 0, 3, 2)));
    }

}
