package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PointsTest {
    static Stream<Arguments> createPointsByNamesSuccessParam() {
        return Stream.of(
                Arguments.arguments(
                        new ArrayList<>(List.of("kero", "giro")),
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 0,  2),
                                new Point("giro", 1,  2)
                        )))
                ),
                Arguments.arguments(
                        new ArrayList<>(List.of("kero", "giro", "zero")),
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 0,  3),
                                new Point("giro", 1,  3),
                                new Point("zero", 2,  3)
                        )))
                )
        );
    }

    @DisplayName("Points 생성 성공")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("createPointsByNamesSuccessParam")
    void createPointsByNamesSuccess(List<String> names, Points expectedPoints) {
        Points points = Points.createPointsByNames(names);
        assertThat(points).isEqualTo(expectedPoints);
    }

    static Stream<Arguments> movedPointsParam() {
        return Stream.of(
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(true))),
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 0,  2),
                                new Point("giro", 1,  2)
                        ))),
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 1,  2),
                                new Point("giro", 0,  2)
                        )))
                ),
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(false))),
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 0,  2),
                                new Point("giro", 1,  2)
                        ))),
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 0,  2),
                                new Point("giro", 1,  2)
                        )))
                ),
                Arguments.arguments(
                        new Line(new ArrayList<>(List.of(true, false, true))),
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 0,  4),
                                new Point("giro", 1,  4),
                                new Point("zero", 2,  4),
                                new Point("hero", 3,  4)
                        ))),
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 1,  4),
                                new Point("giro", 0,  4),
                                new Point("zero", 3,  4),
                                new Point("hero", 2,  4)
                        )))
                )
        );
    }

    @DisplayName("movedPoints 성공")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("movedPointsParam")
    void movedPoints(Line line, Points points, Points expectedPoints) {
        Points movedPoints = points.movedPoints(line);
        assertThat(movedPoints).isEqualTo(expectedPoints);
    }

    static Stream<Arguments> filteredPointsParam() {
        return Stream.of(
                Arguments.arguments(
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 0,  2),
                                new Point("giro", 1,  2)
                        ))),
                        "kero",
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 0,  2)
                        )))
                ),
                Arguments.arguments(
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 0,  2),
                                new Point("giro", 1,  2)
                        ))),
                        "giro",
                        new Points(new ArrayList<>(List.of(
                                new Point("giro", 1,  2)
                        )))
                ),
                Arguments.arguments(
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 0,  2),
                                new Point("giro", 1,  2)
                        ))),
                        "all",
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 0,  2),
                                new Point("giro", 1,  2)
                        )))
                ),
                Arguments.arguments(
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 1,  4),
                                new Point("firo", 3,  4),
                                new Point("zero", 2,  4),
                                new Point("hero", 0,  4)
                        ))),
                        "zero",
                        new Points(new ArrayList<>(List.of(
                                new Point("zero", 2,  4)
                        )))
                ),
                Arguments.arguments(
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 1,  4),
                                new Point("firo", 0,  4),
                                new Point("zero", 3,  4),
                                new Point("hero", 2,  4)
                        ))),
                        "all",
                        new Points(new ArrayList<>(List.of(
                                new Point("kero", 1,  4),
                                new Point("firo", 0,  4),
                                new Point("zero", 3,  4),
                                new Point("hero", 2,  4)
                        )))
                )
        );
    }

    @DisplayName("filteredPoints 성공")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("filteredPointsParam")
    void filteredPoints(Points points, String name, Points expectedPoints) {
        Points filteredPoints = points.filteredPoints(name);
        assertThat(filteredPoints).isEqualTo(expectedPoints);
    }

    static Stream<Arguments> pointNameMaxSizeParam() {
        return Stream.of(
                Arguments.arguments(
                        new Points(new ArrayList<>(List.of(
                                new Point("1234567890", 0,  2)
                        ))),
                        10
                ),
                Arguments.arguments(
                        new Points(new ArrayList<>(List.of(
                                new Point("1", 0,  2)
                        ))),
                        1
                ),
                Arguments.arguments(
                        new Points(new ArrayList<>(List.of(
                                new Point("1234567890", 0,  2),
                                new Point("giro", 1,  2)
                        ))),
                        10
                ),
                Arguments.arguments(
                        new Points(new ArrayList<>(List.of(
                                new Point("1", 0,  2),
                                new Point("2", 1,  2)
                        ))),
                        1
                ),
                Arguments.arguments(
                        new Points(new ArrayList<>(List.of(
                                new Point("123", 1,  4),
                                new Point("123456", 3,  4),
                                new Point("12", 2,  4),
                                new Point("123456789", 0,  4)
                        ))),
                        9
                )
        );
    }

    @DisplayName("pointNameMaxSize 성공")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("pointNameMaxSizeParam")
    void pointNameMaxSize(Points points, int expectedSize) {
        int maxSize = points.pointNameMaxSize();
        assertThat(maxSize).isEqualTo(expectedSize);
    }
}