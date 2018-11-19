package view;

import domain.LadderGameInfo;
import domain.LadderResult;
import domain.gamer.Gamer;
import domain.ladder.LadderLine;
import domain.point.LineVertex;
import domain.point.Point;
import domain.reward.Reward;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static domain.gamer.Gamer.MAX_GAMER_NAME_LENGTH;

/**
 * Created by hspark on 16/11/2018.
 */
public class OutputView {

	public static final String LADDER_LAYER_STR = "|";
	public static final String LADDER_LINE_CHR = "-----";
	public static final String LADDER_NON_LINE_CHR = "     ";

	public static void printLadder(LadderResult ladderResult, LadderGameInfo ladderGameInfo) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Gamer gamer : ladderGameInfo.getGamers().getGamerList()) {
			stringBuilder.append(StringUtils.rightPad(gamer.toString(), MAX_GAMER_NAME_LENGTH + 1));
		}
		stringBuilder.append("\n");

		List<LadderLine> ladderLines = ladderResult.getLadderLines();

		for (LadderLine ladderLine : ladderLines) {
			stringBuilder = printLine(stringBuilder, ladderLine);
		}

		for (Reward reward : ladderGameInfo.getRewards().getRewardList()) {
			stringBuilder.append(StringUtils.rightPad(reward.toString(), MAX_GAMER_NAME_LENGTH + 1));
		}

		System.out.println(stringBuilder.toString());
	}

	private static StringBuilder printLine(StringBuilder stringBuilder, LadderLine ladderLine) {
		List<LineVertex> lineVertices = ladderLine.getLineVertices();
		lineVertices.stream().limit(lineVertices.size() - 1).forEach(lineVertex -> {
			stringBuilder.append(LADDER_LAYER_STR);
			stringBuilder.append(lineVertex.isRightDirection() ? LADDER_LINE_CHR : LADDER_NON_LINE_CHR);
		});
		stringBuilder.append("|\n");
		return stringBuilder;
	}

	public static void printReward(LadderResult ladderResult, LadderGameInfo ladderGameInfo, String gamerName) {

		System.out.println("실행결과");
		if (LadderGameInfo.ALL_GAMER.equalsIgnoreCase(gamerName)) {
			printAll(ladderResult, ladderGameInfo);
			return;
		}

		Point startPoint = ladderGameInfo.findStartPointByGamerName(gamerName);
		Point endPoint = ladderResult.getEndPointByStartPoint(startPoint);
		System.out.println(ladderGameInfo.getRewardByPoint(endPoint));
	}

	private static void printAll(LadderResult ladderResult, LadderGameInfo ladderGameInfo) {
		for (Gamer gamer : ladderGameInfo.getGamers().getGamerList()) {
			Point startPoint = ladderGameInfo.findStartPointByGamerName(gamer.getName());
			Point endPoint = ladderResult.getEndPointByStartPoint(startPoint);
			System.out.println(gamer.getName() + " : " + ladderGameInfo.getRewardByPoint(endPoint));
		}
	}
}
