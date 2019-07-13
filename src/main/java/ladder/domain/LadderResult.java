package ladder.domain;

import java.util.Map;
import java.util.function.BiConsumer;

public class LadderResult {

	private final Map<Player, Reward> ladderResult;

	public LadderResult(Map<Player, Reward> ladderResult) {
		this.ladderResult = ladderResult;
	}

	public void getForEach(BiConsumer<? super Player, ? super Reward> action) {
		ladderResult.forEach(action);
	}

	public String rewardOfPlayer(String playerName) {
		return ladderResult.get(ladderResult.keySet().stream()
				.filter(player -> player.isPlayerName(playerName))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("사다리 게임에 속한 Player가 아닙니다.")))
				.getReward();
	}

}
