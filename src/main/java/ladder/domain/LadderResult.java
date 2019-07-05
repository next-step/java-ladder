package ladder.domain;

import java.util.Map;
import java.util.function.BiConsumer;

public class LadderResult {


	private final Map<Player, Reward> ladderReuslt;

	public LadderResult(Map<Player, Reward> ladderReuslt) {
		this.ladderReuslt = ladderReuslt;
	}

	public void getForEach(BiConsumer<? super Player, ? super Reward> action) {
		ladderReuslt.forEach(action);
	}

	public String rewardOfPlayer(String playerName) {
		return ladderReuslt.get(ladderReuslt.keySet().stream()
				.filter(player -> player.isPlayerName(playerName))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("사다리 게임에 속한 Player가 아닙니다.")))
				.getReward();
	}

}
