package ladder.domain.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListTest {

    private List<String> strings;

    @BeforeEach
    void setUp() {
        strings = new ArrayList<>(List.of("11", "12", "13", "14"));
    }

    @Test
    void indexOf_가로_포지션이용() {
        String findTarget = "12";

        int integer = strings.indexOf(findTarget);

        Assertions.assertThat(integer).isEqualTo(1);
    }
    @Test
    void move() {
        List<String> result = new ArrayList<>();
        strings.forEach(string -> {
            int random = (int) (Math.random() * 4);
            result.add(strings.get(random));
        });
        System.out.println("result = " + result);
    }
}
