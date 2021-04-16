package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class PointsGenerationTest {

    private int size;
    private PointsGeneration pointsGeneration;

    @BeforeEach
    void init() {
        size = 10;
        pointsGeneration = new PointsGeneration(size);
    }


    @DisplayName("points가 전부 false일 경우")
    @Test
    void getPointsAllfalseTest() {
        List<Boolean> points = pointsGeneration.getPoints(() -> false);
        List<Boolean> expectedPoints = IntStream.range(0, size)
                .mapToObj(index -> false)
                .collect(Collectors.toList());

        Assertions.assertEquals(points, expectedPoints);
    }

    @DisplayName("points가 전부 true일 경우")
    @Test
    void getPointsAllTrueTest() {
        List<Boolean> points = pointsGeneration.getPoints(() -> true);
        List<Boolean> expectedPoints = IntStream.range(0, size)
                .mapToObj(index -> true)
                .collect(Collectors.toList());

        Assertions.assertEquals(points, expectedPoints);
    }

    @DisplayName("points가 false와 true가 섞일 경우")
    @Test
    void getPointsShuffleTest() {
        CustomCondition customCondition = new CustomCondition();
        List<Boolean> points = pointsGeneration.getPoints(customCondition);

        List<Boolean> expectedPoints = IntStream.range(0, size)
                .mapToObj(index -> {
                    if (index % 2 == 0) {
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());

        Assertions.assertEquals(points, expectedPoints);
    }

}