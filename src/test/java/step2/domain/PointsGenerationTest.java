package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LineGenerationTest {

    private int size;
    private LineGeneration lineGeneration;

    @BeforeEach
    void init() {
        size = 10;
        lineGeneration = new LineGeneration(size);
    }


    @DisplayName("points가 전부 false일 경우")
    @Test
    void getPointsAllfalseTest() {
        List<Boolean> points = lineGeneration.getPoints(condition -> false);
        List<Boolean> expectedPoints = IntStream.range(0, size)
                .mapToObj(index -> false)
                .collect(Collectors.toList());

        Assertions.assertEquals(points, expectedPoints);
    }

    @DisplayName("points가 전부 true일 경우")
    @Test
    void getPointsAllTrueTest() {
        List<Boolean> points = lineGeneration.getPoints(condition -> true);
        List<Boolean> expectedPoints = IntStream.range(0, size)
                .mapToObj(index -> true)
                .collect(Collectors.toList());

        Assertions.assertEquals(points, expectedPoints);
    }

    @DisplayName("points가 false와 true가 섞일 경우")
    @Test
    void getPointsShuffleTest() {
        CustomCondition customCondition = new CustomCondition();
        List<Boolean> points = lineGeneration.getPoints(customCondition);

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