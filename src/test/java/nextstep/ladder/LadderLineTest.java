package nextstep.ladder;

import nextstep.ladder.model.LadderLine;
import org.junit.jupiter.api.Test;

public class LadderLineTest {

    @Test
    public void init(){
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }

    @Test
    public void move(){
        LadderLine line = LadderLine.init(2);
        System.out.println("Points : "+ line.toString());
        System.out.println("ladder result : "+ line.move(0));
        System.out.println("Points : "+ line.toString());
    }
}
