package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.ladder.model.strategy.RandomPointPickerStrategy;

class LineTest {

    @ParameterizedTest(name = "사람 수가 주어질 때, 가로 이동이 가능한 Line 객체를 생성합니다; 사람 수: {0}")
    @ValueSource(ints = {2, 3, 4, 5})
    void create(int countOfPerson) {
        Line line = new Line(countOfPerson, new RandomPointPickerStrategy());
    }

    @ParameterizedTest(name = "부족한 인원의 사람 수가 주어질 때, 예외를 반환합니다.")
    @ValueSource(ints = {0, 1})
    void createWithInsufficientPeopleCount(int countOfPerson) {
        assertThatThrownBy(() -> new Line(countOfPerson, new RandomPointPickerStrategy()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("최소 2명이 존재해야 사다리에서 이동이 가능합니다");
    }

    @ParameterizedTest(name = "사다리 게임의 룰에 따라 Line을 생성할 때, 의도한 대로 Point가 생성되어야 합니다; 인원 수: {0}")
    @MethodSource("provideLineSource")
    void hasValidMovingPoints(int countOfPerson, List<Boolean> expectedMovingPoints) {
        List<Boolean> movingPoints = new Line(countOfPerson, () -> true).getMovingPoints();
        assertThat(movingPoints).isEqualTo(expectedMovingPoints);
    }

    private static Stream<Arguments> provideLineSource() {
        return Stream.of(
            Arguments.of(3, List.of(true, false)),
            Arguments.of(4, List.of(true, false, true)),
            Arguments.of(5, List.of(true, false, true, false))
        );
    }
}
