package step4.view;

import step4.domain.ladder.*;
import step4.domain.ladder.dto.LadderDrawDTO;
import step4.domain.ladder.dto.PlayerWinningInfo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderGameResultView implements ResultView {
    public static final String VERTICAL_LINE = "|";
    public static final String HORIZON_LINE_MARKED = "-----";
    public static final String HORIZON_LINE_WHITE =  "     ";
    public static final String LADDER_RESULT = "사다리 결과";
    private final StringBuilder sb;

    public LadderGameResultView() {
        sb = new StringBuilder();
    }

    @Override
    public void draw(LadderDrawDTO drawDTO) {
        System.out.println(LADDER_RESULT);

        drawLadder(drawDTO.getLadderPlayers(), drawDTO.getLadder());
        drawResult(drawDTO.getLadderResults());
    }

    private void drawResult(LadderResults ladderResults) {
        clearStringBuilder();
        System.out.println(ladderResults.toString());

    }

    @Override
    public void drawLadder(LadderPlayers players, Ladder ladder) {
        clearStringBuilder();
        append(players.toString());
        ladder.forEach(this::drawLine);

        System.out.println(sb.toString());
    }

    @Override
    public void drawPlayResult(PlayerWinningInfo playerWinningInfo) {
        System.out.println(playerWinningInfo.getWinningResult());
    }

    @Override
    public void drawPlayResultAll(LadderGameResults playResults) {
        clearStringBuilder();
        playResults.forEach(playerWinningInfo ->
                append(String.format("%s: %s",
                playerWinningInfo.getPlayer().getName(),
                playerWinningInfo.getWinningResult()
                )));

        System.out.println(sb.toString());
    }

    private void drawLine(Line line) {
        List<Boolean> points = line.getPoints().getPoints();

        String collect = points.stream()
                .map(this::getMarkingCode)
                .collect(Collectors.joining(VERTICAL_LINE));

        append(String.format("%s%s%s", VERTICAL_LINE, collect, VERTICAL_LINE));
    }

    private String getMarkingCode(Boolean exists) {
        return exists
                ? HORIZON_LINE_MARKED
                : HORIZON_LINE_WHITE;
    }

    private void append(String ...args) {
        String separator = System.lineSeparator();
        Stream.of(args)
                .forEach(arg-> sb.append(arg).append(separator));
    }

    private void clearStringBuilder() {
        sb.delete(0, sb.length());
    }
}
