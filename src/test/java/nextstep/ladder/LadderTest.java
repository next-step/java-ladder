package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리게임을 만들 수 있다")
    @Test
    void ladder() {
        int heightOfLadder = 5;
        int countOfPerson = 3;
        Ladder ladder = Ladder.of(countOfPerson, heightOfLadder);

        List<Line> lines =  ladder.getLadderLines();

        assertThat(lines.size()).isEqualTo(heightOfLadder);
        assertThat(lines.get(0).size()).isEqualTo(countOfPerson);
    }


}
