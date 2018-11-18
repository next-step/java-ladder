package ladder.domain;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    Line oneLine;

    @Before
    public void setUp() {
        oneLine = new Line(Arrays.asList(new Position(0,false, true),
                new Position(1,true, false),
                new Position(2,false, true),
                new Position(3,true, false)

        ));
    }

    @Test
    public void 사다리_가장_왼쪽플레이어_움직임_테스트() {
        int result = oneLine.moveToNextPoint(0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 사다리_가장_오른쪽플레이어_움직임_테스트() {
        int result = oneLine.moveToNextPoint(3);
        assertThat(result).isEqualTo(2);
    }
}