package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rewards {
	List<Reward> rewards;

	private Rewards(List<Reward> rewards) {
		this.rewards = rewards;
	}

	public static Rewards of(String rewards) {
		return new Rewards(Arrays.stream(rewards.split(","))
				.map(reward -> new Reward(reward.trim()))
				.collect(Collectors.toList()));
	}

	public int size() {
		return rewards.size();
	}

	public Reward rewardByResult(Point result) {
		return rewards.get(result.getIndex());
	}
	
	public Stream<Reward> getStream(){
		return rewards.stream();
	}
}
