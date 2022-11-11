package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineTest {

    boolean isNextIndexConditionOfTrueValue(int index) {
        return (index % 2 == 1);
    }

    @DisplayName("Line의 이전 Point가 true이면 다음 Point는 false이다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9})
    void Should_Be_False_When_Given_Previous_Point_Is_True(int countOfPerson) {
        LineGenerationStrategy trueLineGenerationStrategy = new TrueLineGenerationStrategy();

        Line line = Line.of(trueLineGenerationStrategy, countOfPerson);
        List<Boolean> points = line.getPoints();
        Assertions.assertThat(IntStream.range(0, countOfPerson - 1)
            .filter(this::isNextIndexConditionOfTrueValue)
            .mapToObj(points::get)
            .collect(Collectors.toList())).containsOnly(Boolean.FALSE);
    }
}
