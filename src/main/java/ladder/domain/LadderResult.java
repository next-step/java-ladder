package ladder.domain;

import java.util.Map;

public class LadderResult {
	private final Map<Player, Reward> ladderReuslt;

	public LadderResult(Map<Player, Reward> ladderReuslt) {
		this.ladderReuslt = ladderReuslt;
	}

	public Map<Player, Reward> getResult() {
		return ladderReuslt;
	}

	public Reward rewardOfPlayer(Player player) {
		return ladderReuslt.get(player);
	}

	public Reward rewardOfPlayer(String playerName) {
		return ladderReuslt.get(ladderReuslt.keySet().stream()
				.filter(player -> player.isPlayerName(playerName))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("사다리 게임에 속한 Player가 아닙니다.")));
	}

}
