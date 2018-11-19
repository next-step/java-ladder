package domain.reward;

import domain.point.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hspark on 18/11/2018.
 */
public class Rewards {
	private List<Reward> rewards;

	public Rewards(List<String> rewards) {
		this.rewards = initRewards(rewards);
	}

	private List<Reward> initRewards(List<String> rewardList) {
		List<Reward> rewards = new ArrayList<>();
		int position = 0;
		for (String reward : rewardList) {
			rewards.add(new Reward(reward, Point.of(position++)));
		}
		return rewards;
	}

	public Reward getRewardByPoint(Point point) {
		return rewards.stream().filter(reward -> reward.isEqualPoint(point)).findFirst().orElseThrow(IllegalAccessError::new);
	}

	public List<Reward> getRewardList() {
		return Collections.unmodifiableList(rewards);
	}

	public int size() {
		return rewards.size();
	}
}
