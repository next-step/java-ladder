package nextstep.ladder.domain;

import java.util.Random;

public class Utils {
	static Random random = new Random();
	static boolean makeRandomBoolean() {
		return random.nextBoolean();
	}
}
