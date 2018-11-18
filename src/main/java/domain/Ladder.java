package domain;

import com.google.common.base.Preconditions;
import domain.dto.GamerDTO;
import domain.dto.LadderLayerDTO;

import java.util.List;

/**
 * Created by hspark on 16/11/2018.
 */
public class Ladder {
	public static final int MIN_LADDER_HEIGHT = 1;
	public static final int NUMBER_TO_GET_WIDTH = 1;

	private Gamers gamers;
	private LadderLayers ladderLayers;
	private Rewards rewards2;

	public Ladder(List<String> gamerNames, List<String> rewards) {
		Preconditions.checkArgument(gamerNames.size() == rewards.size(), "상품 수와 인원수가 맞지 않습니다.");
		this.gamers = new Gamers(gamerNames);
		this.rewards2 = new Rewards(rewards);
	}

	public void drawLadder(int height, LadderLineSupplier supplier) {
		Preconditions.checkArgument(height > MIN_LADDER_HEIGHT, "사다리 높이가 너무 낮습니다.");
		this.ladderLayers = new LadderLayers(height, getWidth());
		ladderLayers.drawAllLadders(supplier);
	}

	public LadderResult getLadderGameResult() {
		List<LadderLayerDTO> ladderLayerDTOS = ladderLayers.getDTOs();
		List<GamerDTO> gamerDTOS2 = gamers.getDTOs();
		List<String> rewards = rewards2.getRewards();
		return new LadderResult(gamerDTOS2, ladderLayerDTOS, rewards);
	}

	public void moveAll() {
		ladderLayers.moveAll(gamers);
	}

	private int getWidth() {
		return gamers.size() - NUMBER_TO_GET_WIDTH;
	}
}
