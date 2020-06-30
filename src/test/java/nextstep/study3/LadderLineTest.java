package nextstep.study3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study3.domain.LadderLine;

class LadderLineTest {

	@Test
	@DisplayName("")
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(0));
    }

}
