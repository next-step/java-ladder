package JavaLadder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    @Test
    @DisplayName("사다리생성테스트")
    public void ladderContructorTest() {
        String name = "test1,test2";
        String prize = "prize1,prize2";
        GameInformation gameInformation = new GameInformation(name, prize);
        Ladder ladder = new Ladder(5,gameInformation);
        assertThat(ladder.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리내에라인구하기테스트")
    public void numberOfLineOnLadderTest() {
        String name = "test1,test2,test3,test4";
        String prize = "prize1,prize2,prize3,prize4";
        GameInformation gameInformation = new GameInformation(name, prize);
        Ladder ladder = new Ladder(5,gameInformation);
        assertThat(ladder.getLineByLadder(0).size()).isEqualTo(3);
    }
}
