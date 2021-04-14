package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @DisplayName("사다리가 생성됬을 경우")
    @Test
    void lineCreatedTest() {
        int size = 2;
        List<Boolean> expectedPoints = IntStream.range(0, 2)
                .mapToObj(index -> true)
                .collect(Collectors.toList());

        Line line = new Line(expectedPoints);
        Assertions.assertEquals(line.toString(), "|-----|-----");
    }

    @DisplayName("사다리가 생성이 안됬을 경우")
    @Test
    void lineNotCreatedTest() {
        int size = 2;
        List<Boolean> expectedPoints = IntStream.range(0, 2)
                .mapToObj(index -> false)
                .collect(Collectors.toList());

        Line line = new Line(expectedPoints);
        Assertions.assertEquals(line.toString(), "|     |     ");
    }
    
    @DisplayName("사다리가 생성여부가 섞였을경우 테스트")
    @Test
    void lineTest() {
        int size = 2;
        List<Boolean> expectedPoints = IntStream.range(0, size)
                .mapToObj(index -> {
                    if (index % 2 == 0) {
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());

        Line line = new Line(expectedPoints);
        Assertions.assertEquals(line.toString(), "|-----|     ");
    }

}