package nextstep.ladder.entity;

import java.util.Random;

public class RandomMakeRootStrategy implements RootMakeStrategy {

	@Override
	public boolean hasRoot() {
		return new Random().nextInt(2) % 2 == 0;
	}
}
