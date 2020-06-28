package study3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
	
	private List<Reward> rewards = new ArrayList<>();
	
	public Rewards(List<String> rewards) {
		this.rewards = initRewards(rewards);
	}

	private List<Reward> initRewards(List<String> rewards) {
		return rewards.stream()
				.map(Reward::new)
				.collect(Collectors.toList());
	}
	public Reward getReward(int position) {
		return this.rewards.get(position);
	}
}
