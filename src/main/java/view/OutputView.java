package view;

import domain.LadderResult;
import domain.dto.GamerDTO;
import domain.dto.LadderLayerDTO;
import domain.dto.LineDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static domain.Gamer.MAX_GAMER_NAME_LENGTH;

/**
 * Created by hspark on 16/11/2018.
 */
public class OutputView {

	public static final String LADDER_LAYER_STR = "|";
	public static final String LADDER_LINE_CHR = "-----";
	public static final String LADDER_NON_LINE_CHR = "     ";

	public static void printLadder(LadderResult ladderResult) {
		List<GamerDTO> gamers = ladderResult.getGamers();

		StringBuilder stringBuilder = new StringBuilder();
		for (GamerDTO gamer : gamers) {
			stringBuilder.append(StringUtils.rightPad(gamer.toString(), MAX_GAMER_NAME_LENGTH + 1));
		}
		stringBuilder.append("\n");

		List<LadderLayerDTO> ladderLines = ladderResult.getLadderLines();

		for (LadderLayerDTO ladderLine : ladderLines) {
			for (LineDTO line : ladderLine.getLineDTOList()) {
				stringBuilder.append(LADDER_LAYER_STR);
				stringBuilder.append(line.isDrawn() ? LADDER_LINE_CHR : LADDER_NON_LINE_CHR);
			}
			stringBuilder.append("|\n");
		}

		List<String> rewardNames = ladderResult.getRewardNames();

		for (String rewardName : rewardNames) {
			stringBuilder.append(StringUtils.rightPad(rewardName, MAX_GAMER_NAME_LENGTH + 1));
		}

		System.out.println(stringBuilder.toString());
	}

	public static void printReward(LadderResult ladderResult, String gamerName) {

		System.out.println("실행결과");
		if (LadderResult.ALL_GAMER.equalsIgnoreCase(gamerName)) {
			printAll(ladderResult);
			return;
		}
		System.out.println(ladderResult.getGameRewardByGamer2(gamerName));
	}

	private static void printAll(LadderResult ladderResult) {
		for (GamerDTO gamer : ladderResult.getGamers()) {
			System.out.println(gamer.getName() + " : " + ladderResult.getGameRewardByGamer2(gamer.getName()));
		}
	}
}
