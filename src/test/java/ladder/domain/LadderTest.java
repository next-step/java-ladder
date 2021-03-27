package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @Test
    public void createLadderTest() throws Exception {
        //given
        int countOfPerson = 5;
        int ladderSize = 5;

        //when
        Ladder ladder = new Ladder(countOfPerson, ladderSize);
        List<Line> lines = ladder.readOnlyLines();

        //then
        assertThat(lines.size()).isEqualTo(ladderSize) ;
    }
}
