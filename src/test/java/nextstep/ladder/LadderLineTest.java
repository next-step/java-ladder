package nextstep.ladder;

import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.RandomMakeStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson, new RandomMakeStrategy()));
    }

    @Test
    public void move_two_person() {
        LadderLine line = LadderLine.init(2, () -> true);
        assertThat(line.move(0)).isEqualTo(1);
    }


    @Test
    public void move_three_person() {
        // |-----|      |
        LadderLine line = LadderLine.init(3, () -> true);
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(2);
    }
}
