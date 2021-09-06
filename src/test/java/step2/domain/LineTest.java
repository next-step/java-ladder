package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    @Test
    void Test() {
        Line line = new Line(2);
        System.out.println(line.getPoints());
    }

    @Test
    void Test2() {
        List<Integer> list = Arrays.asList(1,2,3,4);
        list.stream()
                .map(integer -> integer*2)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}