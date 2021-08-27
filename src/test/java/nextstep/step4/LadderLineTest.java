package nextstep.step4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LadderLineTest {

    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(5);
        System.out.println("ladder result : " + line.toString());
    }

    @Test
    public void lineDraw() {
        List<LadderLine> lines = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            lines.add(LadderLine.init(5));
            System.out.println("line : " + lines.get(i).drawLine());
        }
        lines.get(0).move(0);
    }
}

