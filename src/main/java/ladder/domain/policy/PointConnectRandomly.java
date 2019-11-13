package ladder.domain.policy;

import java.util.concurrent.ThreadLocalRandom;

public class PointConnectRandomly implements PointConnectPolicy {

	@Override
	public boolean shouldConnect() {
		return ThreadLocalRandom.current().nextBoolean();
	}

}
