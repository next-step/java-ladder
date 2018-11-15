package view;

import domain.LadderResult;
import domain.dto.GamerDTO;
import domain.dto.LadderLayerDTO;
import domain.dto.LineDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

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
			stringBuilder.append(StringUtils.rightPad(gamer.toString(), 6));
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
		System.out.println(stringBuilder.toString());
	}
}
