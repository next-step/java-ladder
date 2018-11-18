package domain;

import domain.gamer.Gamers;
import domain.point.Point;
import domain.reward.Reward;
import domain.reward.Rewards;

/**
 * Created by hspark on 18/11/2018.
 */
public class LadderGameInfo {
	public static final String ALL_GAMER = "all";
	private Gamers gamers;
	private Rewards rewards;

	public LadderGameInfo(Gamers gamers, Rewards rewards) {
		this.gamers = gamers;
		this.rewards = rewards;
	}

	public Gamers getGamers() {
		return gamers;
	}

	public Rewards getRewards() {
		return rewards;
	}

	public Point findStartPointByGamerName(String gamerName) {
		return gamers.findByGamerName(gamerName).getPoint();
	}

	public Reward getRewardByPoint(Point point) {
		return rewards.getRewardByPoint(point);
	}
}
