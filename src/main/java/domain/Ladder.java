package domain;

import com.google.common.base.Preconditions;
import domain.dto.GamerDTO;
import domain.dto.LadderLayerDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hspark on 16/11/2018.
 */
public class Ladder {
	private List<Gamer> gamers;
	private List<LadderLayer> ladderLines;

	public Ladder(List<String> gamerNameList, int height, LadderLineSupplier supplier) {
		Preconditions.checkArgument(height > 1, "사다리 높이가 너무 낮습니다.");
		this.gamers = gamerNameList.stream().map(Gamer::new).collect(Collectors.toList());
		this.ladderLines = Stream.iterate(0, i -> i + 1).limit(height)
			.map(integer -> new LadderLayer(gamers.size(), supplier)).collect(Collectors.toList());
	}

	public void drawLadder() {
		ladderLines.stream().forEach(LadderLayer::drawLines);
	}

	public LadderResult getLadderGameResult() {
		List<LadderLayerDTO> lineDTOList = ladderLines.stream().map(LadderLayer::getLadderLineDTO).collect(Collectors.toList());
		List<GamerDTO> gamerDTOList = gamers.stream().map(GamerDTO::of).collect(Collectors.toList());
		return new LadderResult(gamerDTOList, lineDTOList);
	}
}
