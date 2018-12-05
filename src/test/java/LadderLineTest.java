import org.junit.Test;

public class LadderLineTest {

    @Test
    public void init() {
        int sizeOfPerson = 5;
        LadderLine ladderLine = LadderLine.init(sizeOfPerson);
        System.out.println(ladderLine);
    }

    @Test
    public void move() {
        LadderLine init = LadderLine.init(2);
        System.out.println("ladder result :" + init.move(0));
    }
}