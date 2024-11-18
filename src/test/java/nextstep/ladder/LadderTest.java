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
                new Usernames(Arrays.asList("test", "test2", "test3","test4","test5")),
                new Lines(Arrays.asList(
                        new Line(new Points(Arrays.asList(new Point(false, false), new Point(false, true), new Point(true, false), new Point(false, true), new Point(true, false)))),
                        new Line(new Points(Arrays.asList(new Point(false, true), new Point(true, false), new Point(false, false), new Point(false, false), new Point(false, false)))),
                        new Line(new Points(Arrays.asList(new Point(false, true), new Point(true, false), new Point(false, false), new Point(false, true), new Point(true, false)))),
                        new Line(new Points(Arrays.asList(new Point(false, true), new Point(true, false), new Point(false, true), new Point(true, false), new Point(false, false)))),
                        new Line(new Points(Arrays.asList(new Point(false, false), new Point(false, true), new Point(true, false), new Point(false, true), new Point(true, false)))),
                        new Line(new Points(Arrays.asList(new Point(false, false), new Point(false, false), new Point(false, false), new Point(false, true), new Point(true, false))))
                ))
                , Arrays.asList("result1", "result2", "result3","result4","result5"));
    }

    @Test
    @DisplayName("모든 사용자의 사다리 결과")
    public void getAllResult() {
        assertThat(ladder.getResult("all"))
                .isEqualTo("test4:result2\n" +
                "test5:result5\n" +
                "test2:result4\n" +
                "test3:result1\n" +
                "test:result3");
    }

    @Test
    @DisplayName("사용자별 사다리 결과")
    public void getResult() {
        assertThat(ladder.getResult("test4")).isEqualTo("result2");
    }
}
