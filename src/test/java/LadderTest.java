import domain.Ladder;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class LadderTest {

    @Test
    public void numberOfLinesInLadder() {
        Ladder ladder = new Ladder(3,5);
        assertThat(ladder.getNumberOfLines()).isEqualTo(3);
    }

}
