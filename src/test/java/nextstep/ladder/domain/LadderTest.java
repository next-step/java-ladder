package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void create() {
        int verticalLineCount = 4;
        int height = 5;

        Ladder ladder = new Ladder(verticalLineCount, height);
        assertThat(ladder.lines().value().size()).isEqualTo(height);

    }

    @Test
    void 사다리_2차원배열_만들기() {
        //given
        int verticalLineCount = 4;
        Lines lines = new Lines(Arrays.asList(
                new Line(Arrays.asList(true, false, true)),
                new Line(Arrays.asList(false, true, false)),
                new Line(Arrays.asList(true, false, false)),
                new Line(Arrays.asList(false, true, false)),
                new Line(Arrays.asList(true, false, true))
        ));

        //when
        Ladder ladder = new Ladder(verticalLineCount, lines);
        String[][] result = ladder.result();

        //then
        System.out.println(Arrays.deepToString(result));
    }
}
