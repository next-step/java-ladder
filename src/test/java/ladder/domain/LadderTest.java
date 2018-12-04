package ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 사다리생성() {
        People people= People.from("AAA,BBB");
        Ladder ladder = Ladder.from(LadderSize.from(2, people.size()),
                width -> {
                    List<Point> points = Arrays.asList(new Point(Boolean.FALSE));
                    return LadderLine.from(points);
                });


        assertThat(ladder.size()).isEqualTo(2);
    }
}
