package nextstep.study3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study3.domain.LadderLine;

class LadderLineTest {
		
	@Test
	@DisplayName("라인메소드 initLine 검증")
    public void init() {
        int sizeOfPerson = 5;
        LadderLine line = new LadderLine(sizeOfPerson, false);
        System.out.println(line.getLine());
    }

    @Test
    @DisplayName("move 메소드 검증")
    public void move() {
        LadderLine line = new LadderLine(2, false);
        
        System.out.println("ladder result : " + line.move(0));
    }

}
