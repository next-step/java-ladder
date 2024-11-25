package nextstep.ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private static Ladder ladder;

    @BeforeAll
    static void setup() {
        ladder = new Ladder(
                new Usernames(Arrays.asList("test", "test2", "test3")),
                new Lines(Arrays.asList(
                        new Line(new Points(Arrays.asList(new Point(false, false), new Point(false, true), new Point(true, false)))),
                        new Line(new Points(Arrays.asList(new Point(false, true), new Point(true, false), new Point(false, false))))
                ))
                , Arrays.asList("결과1", "결과2", "결과3"));
    }

    @Test
    @DisplayName("모든 사용자의 사다리 결과")
    void getAllResult() {
        assertThat(ladder.getResult("all"))
                .isEqualTo("test2 : 결과3\n" +
                        "test3 : 결과1\n" +
                        "test : 결과2");
    }

    @Test
    @DisplayName("사용자별 사다리 결과")
    void getResult() {
        assertThat(ladder.getResult("test2")).isEqualTo("결과3");
    }
}
