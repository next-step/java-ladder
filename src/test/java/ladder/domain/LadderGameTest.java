package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    static Stream<Arguments> filteredResultByNameParam() {
        return Stream.of(
                Arguments.arguments(
                        new Ladder(1, 1, (LineGenerator) i -> new Line(Arrays.asList(false))),
                        Points.createPointsByNames(new ArrayList<>(Arrays.asList("kero", "zero"))),
                        "kero",
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 0,  2)
                        )))

                ),
                Arguments.arguments(
                        new Ladder(1, 1, (LineGenerator) i -> new Line(Arrays.asList(true))),
                        Points.createPointsByNames(new ArrayList<>(Arrays.asList("kero", "zero"))),
                        "zero",
                        new Points(new ArrayList<>(List.of(
                                new Point("zero", 0,  2)
                        )))

                ),
                Arguments.arguments(
                        new Ladder(3, 3, (LineGenerator) i -> new Line(Arrays.asList(true, false, true))),
                        Points.createPointsByNames(new ArrayList<>(Arrays.asList("kero", "giro", "zero", "hero"))),
                        "all",
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 1,  4),
                                new Point("giro", 0,  4),
                                new Point("zero", 3,  4),
                                new Point("hero", 2,  4)
                        )))

                ),
                Arguments.arguments(
                        new Ladder(3, 3, (LineGenerator) i -> new Line(Arrays.asList(true, false, true))),
                        Points.createPointsByNames(new ArrayList<>(Arrays.asList("kero", "giro", "zero", "hero"))),
                        "giro",
                        new Points(new ArrayList<>(List.of(
                                new Point("giro", 0,  4)
                        )))

                )
        );
    }

    @DisplayName("LadderGame 생성 성공")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("filteredResultByNameParam")
    void filteredResultByName(Ladder ladder, Points participants, String name, Points expectedPoints) {
        LadderGame ladderGame = new LadderGame(ladder, participants);
        Points points = ladderGame.filteredResultByName(name);
        assertThat(points).isEqualTo(expectedPoints);
    }
}
