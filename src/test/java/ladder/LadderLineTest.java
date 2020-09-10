package ladder;

import org.junit.Test;

import ladder.domain.line.LadderLine;

public class LadderLineTest {

	@Test
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
