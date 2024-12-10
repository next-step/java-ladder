package nextstep.ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Ladder2Test {

    private static Ladder2 ladder;

    @BeforeAll
    static void setup() {
        ladder = new Ladder2(Arrays.asList(
                new Line2(
                        Arrays.asList(new Cross(0, new Point(false, false)), new Cross(1, new Point(false, true)), new Cross(2, new Point(true, false)))
                ), new Line2(
                        Arrays.asList(new Cross(0, new Point(false, true)), new Cross(1, new Point(true, false)), new Cross(2, new Point(false, false)))
                ), new Line2(
                        Arrays.asList(new Cross(0, new Point(false, false)), new Cross(1, new Point(false, true)), new Cross(2, new Point(true, false)))
                )
        ));
    }

    @Test
    void move() {
        assertThat(ladder.move(1)).isEqualTo(1);
    }

    @Test
    @DisplayName("모든 사용자의 사다리 출력")
    void printResult() {
        System.out.println(ladder.getLadderForPrint("-----", "     "));
    }

    @Test
    @DisplayName("특정 사용자의 사다리 결과")
    void getResultByUserIndex() {
        assertThat(ladder.move(0))
                .isEqualTo(2);
    }

    @Test
    @DisplayName("모든 사용자의 사다리 결과")
    void getAllResult() {
        Map<Integer, Integer> result = new HashMap<>();
        result.put(0, 2);
        result.put(1, 1);
        result.put(2, 0);

        assertThat(ladder.getAllResult())
                .isEqualTo(result);
    }
}
