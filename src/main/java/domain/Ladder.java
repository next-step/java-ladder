package domain;

import com.google.common.base.Preconditions;
import domain.dto.GamerDTO;
import domain.dto.LadderLayerDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by hspark on 16/11/2018.
 */
public class Ladder {
	public static final int MIN_LADDER_HEIGHT = 1;
	public static final int NUMBER_TO_GET_WIDTH = 1;

	private List<Gamer> gamers;
	private List<LadderLayer> ladderLayers;
	private List<String> rewards;

	public Ladder(List<String> gamerNameList, List<String> rewardList) {
		Preconditions.checkArgument(gamerNameList.size() == rewardList.size(), "상품 수와 인원수가 맞지 않습니다.");
		this.gamers = initGamer(gamerNameList);
		this.rewards = rewardList;
	}

	public void drawLadder(int height, LadderLineSupplier supplier) {
		Preconditions.checkArgument(height > MIN_LADDER_HEIGHT, "사다리 높이가 너무 낮습니다.");
		this.ladderLayers = IntStream.range(MIN_LADDER_HEIGHT - 1, height).mapToObj(integer -> new LadderLayer(getWidth()))
			.collect(Collectors.toList());
		ladderLayers.stream().forEach(ladderLayer -> ladderLayer.drawLines(supplier));
	}

	public LadderResult getLadderGameResult() {
		List<LadderLayerDTO> lineDTOList = ladderLayers.stream().map(LadderLayer::getLadderLineDTO).collect(Collectors.toList());
		List<GamerDTO> gamerDTOList = gamers.stream().map(GamerDTO::of).collect(Collectors.toList());
		return new LadderResult(gamerDTOList, lineDTOList, rewards);
	}

	public void moveAll() {
		ladderLayers.stream().forEach(this::moveAllGamer);
	}

	private void moveAllGamer(LadderLayer ladderLayer) {
		for (Gamer gamer : gamers) {
			LadderLine ladderLine = ladderLayer.getPassableLadderLine(gamer).orElseThrow(IllegalAccessError::new);
			gamer.passLine(ladderLine);
		}
	}

	private List<Gamer> initGamer(List<String> gamerNameList) {
		List<Gamer> gamers = new ArrayList<>();
		int position = 0;
		for (String gamerName : gamerNameList) {
			gamers.add(new Gamer(gamerName, position++));
		}
		return gamers;
	}

	private int getWidth() {
		return gamers.size() - NUMBER_TO_GET_WIDTH;
	}
}
