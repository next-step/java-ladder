import domain.Ladder;
import org.junit.Test;

public class LadderTest {
    @Test
    public void 사다리그리기() {
        int depth = 5;
        int countOfPerson = 4;
        Ladder ladder = Ladder.from(depth, countOfPerson, defaultLadderGenerator);
        System.out.println(ladder.drawLadder());
    }

    @Test
    public void 사다리타기결과() {
        int depth = 3;
        int countOfPerson = 4;
        Ladder ladder = Ladder.from(depth, countOfPerson, defaultLadderGenerator);
        System.out.println(ladder.drawLadder());
        System.out.println(ladder.trackingLadder(countOfPerson));
    }
}
