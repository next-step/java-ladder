package study3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
	
	private List<String> rewards = new ArrayList<>();
	
	public Rewards(List<String> rewards) {
		this.rewards = Collections.unmodifiableList(rewards.stream()
                .map(String::new)
                .collect(Collectors.toList()));
	}

	public String getReward(int position) {
		return this.rewards.get(position);
	}
	
}
