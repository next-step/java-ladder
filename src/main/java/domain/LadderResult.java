package domain;

import domain.dto.GamerDTO;
import domain.dto.LadderLayerDTO;

import java.util.List;

/**
 * Created by hspark on 16/11/2018.
 */
public class LadderResult {
	private List<GamerDTO> gamers;
	private List<LadderLayerDTO> ladderLines;

	public LadderResult(List<GamerDTO> gamers, List<LadderLayerDTO> ladderLines) {
		this.gamers = gamers;
		this.ladderLines = ladderLines;
	}

	public List<GamerDTO> getGamers() {
		return gamers;
	}

	public List<LadderLayerDTO> getLadderLines() {
		return ladderLines;
	}
}
