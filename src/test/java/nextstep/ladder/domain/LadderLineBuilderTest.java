package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.TestLadderPointStrategy.NO_LINE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderLineBuilderTest {
    @Test
    public void create() {
        assertThat(LadderLineBuilder.of(2, NO_LINE_STRATEGY)).isExactlyInstanceOf(LadderLineBuilder.class);
    }

    static Stream<Arguments> parseCreateFailed() {
        return Stream.of(
                Arguments.of(1, NO_LINE_STRATEGY),
                Arguments.of(2, null)
        );
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @MethodSource("parseCreateFailed")
    public void createFailed(int sizeOfRail, LadderPointGenerateStrategy strategy) {
        assertThatIllegalArgumentException().isThrownBy(() -> LadderLineBuilder.of(sizeOfRail, strategy));
    }

    static List<Point> generateLadderPoints(int sizeOfPerson, LadderPointGenerateStrategy strategy) {
        Point point = Point.first(strategy.generatePoint());
        List<Point> points = new ArrayList<>(sizeOfPerson);
        points.add(point);
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(strategy.generatePoint());
            points.add(point);
        }
        points.add(point.last());
        return points;
    }

    static Stream<Arguments> parseBuildArguments() {
        return Stream.of(
                Arguments.of(2, NO_LINE_STRATEGY),
                Arguments.of(5, new TestLadderPointStrategy.ReverseLineStrategy())
        );
    }

    @ParameterizedTest(name = "build: {arguments}")
    @MethodSource("parseBuildArguments")
    public void build(int sizeOfPerson, LadderPointGenerateStrategy strategy) {
        assertThat(LadderLineBuilder.of(sizeOfPerson, strategy).build()).hasSameElementsAs(generateLadderPoints(sizeOfPerson, strategy));
    }
}
