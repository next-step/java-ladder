package domain;

import domain.dto.GamerDTO;
import domain.dto.LadderLayerDTO;

import java.util.*;

/**
 * Created by hspark on 16/11/2018.
 */
public class LadderResult {

	public static final String ALL_GAMER = "all";
	private List<GamerDTO> gamers;
	private List<LadderLayerDTO> ladderLines;
	private List<String> rewards;

	public LadderResult(List<GamerDTO> gamers, List<LadderLayerDTO> ladderLines, List<String> rewards) {
		this.gamers = gamers;
		this.ladderLines = ladderLines;
		this.rewards = rewards;
	}

	public List<GamerDTO> getGamers() {
		return Collections.unmodifiableList(gamers);
	}

	public List<LadderLayerDTO> getLadderLines() {
		return Collections.unmodifiableList(ladderLines);
	}

	public List<String> getRewardNames() {
		return Collections.unmodifiableList(rewards);
	}

	public String getGameRewardByGamer2(String gamerName) {
		Optional<GamerDTO> gamerDTOOptional = gamers.stream().filter(gamerDTO -> gamerDTO.isEqualName(gamerName)).findFirst();
		GamerDTO gamerDTO = gamerDTOOptional.orElseThrow(IllegalAccessError::new);
		return rewards.get(gamerDTO.getPoint().getInteger());
	}
}
