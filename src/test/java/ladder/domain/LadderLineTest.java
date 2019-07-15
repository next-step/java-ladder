package ladder.domain;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class LadderLineTest {
    @Test
    @DisplayName("사다리 생성")
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }

    @Test
    @DisplayName("사다리 이동")
    public void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}