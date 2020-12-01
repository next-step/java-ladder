package step2.hint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderLineTest {

    @Test
    void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }
    @Test
    void move(){
        LadderLine line = LadderLine.init(2);
        System.out.println("line = " + line.move(0));
    }
}