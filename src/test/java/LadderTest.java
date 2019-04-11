import domain.Ladder;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class LadderTest {

    @Test
    public void numberOfLinesInLadder() {
        Ladder ladder = new Ladder(3,5);
        assertThat(ladder.getNumberOfLines()).isEqualTo(3);
    }

    @Test
    public void move() {
        Ladder ladder = new Ladder(3,5);
        //assertThat(ladder.move(0))..?
        //랜덤하게 이루어진 ladder 내부에 대한 테스트?
    }
}
