package step2;

import org.junit.jupiter.api.Test;
import step2.model.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class LadderTest {
    @Test
    public void 사다리생성_높이_빈값_null() {
        assertThatThrownBy(() -> new Ladder(null, 5, new RandomLadderStrategy()))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Ladder("", 5, new RandomLadderStrategy()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 사다리생성_높이_0() {
        assertThatThrownBy(() -> new Ladder("0", 5, new RandomLadderStrategy()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 사다리_크기_체크() {
        //given
        Ladder ladder = new Ladder("5", 4, new RandomLadderStrategy());
        ladder.generateLine(new RandomLadderStrategy());

        //when
        List<List<Boolean>> result = ladder.getLadder();

        //then
        assertThat(result.size()).isEqualTo(5);
        for (int i = 0; i < 5; i++) {
            assertThat(result.get(i).size()).isEqualTo(3);
        }
    }

    @Test
    public void 사다리_라인_생성() {
        //given
        Line expectLine = new Line(Arrays.asList(true, false, true));
        Ladder expectLadder = new Ladder(Arrays.asList(expectLine));

        //when
        Ladder actual = new Ladder("1", 4, () -> true);

        //then
        assertThat(actual).isEqualTo(expectLadder);
    }

}
