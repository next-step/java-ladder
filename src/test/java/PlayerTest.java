import domain.Player;
import org.junit.Test;

public class PlayerTest {

    @Test(expected = IllegalArgumentException.class)
    public void invalidPlayerName() {
        Player player = new Player("nextstep");
    }

}
