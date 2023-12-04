package ladder.view;

import ladder.domain.LadderResult;
import ladder.domain.PlayLadder;
import ladder.domain.Point;
import ladder.utils.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String DASH = "-";
    private static final String BLANK = " ";
    private static final String PIPE = "|";

    public void printLadder(PlayLadder playLadder) {
        System.out.println();
        StringBuffer stringBuffer = new StringBuffer();
        createHaeder(playLadder, stringBuffer);
        createBody(playLadder, stringBuffer);
        createFooter(playLadder, stringBuffer);

        System.out.println(stringBuffer);
    }

    private void createHaeder(PlayLadder playLadder, StringBuffer stringBuffer) {
        stringBuffer.append("사다리 결과").append("\n");
        stringBuffer.append(playLadder.players()
                .stream()
                .map(player -> fixedRow(player.name(), playLadder.lengthMax()))
                .collect(Collectors.joining()));
        stringBuffer.append("\n");
    }

    private String fixedRow(String name, long nameLengthMax) {
        return StringUtils.leftPad(name, nameLengthMax + 1, BLANK);
    }

    private void createBody(PlayLadder playLadder, StringBuffer stringBuffer) {
        playLadder.rows()
                .forEach(row -> {
                    stringBuffer.append(createRow(row.values(), playLadder.lengthMax()));
                    stringBuffer.append("\n");
                });
    }

    private String createRow(List<Point> points, int lengthMax) {
        return points.stream()
                .map(point -> createPoint(point.left(), onPath(lengthMax), offPath(lengthMax)))
                .collect(Collectors.joining());
    }

    private String createPoint(Boolean point, String onPath, String offPath) {
        return point ? onPath : offPath;
    }

    private static String onPath(int lengthMax) {
        return DASH.repeat(lengthMax) + PIPE;
    }

    private static String offPath(int lengthMax) {
        return BLANK.repeat(lengthMax) + PIPE;
    }

    private void createFooter(PlayLadder playLadder, StringBuffer stringBuffer) {
        playLadder.prizes()
                .forEach(prize -> stringBuffer.append(fixedRow(prize.value(), playLadder.lengthMax())));
    }

    public void printLadderResult(Map<String, LadderResult> ladderResults, String resultType) {
        System.out.println();
        System.out.println("실행 결과");
        if (playerType(ladderResults, resultType)) {
            printResultPlayer(ladderResults, resultType);
            return;
        }

        printResultAll(ladderResults);
    }

    private boolean playerType(Map<String, LadderResult> move, String resultType) {
        return move.containsKey(resultType);
    }

    private void printResultPlayer(Map<String, LadderResult> ladderResults, String resultType) {
        LadderResult ladderResult = ladderResults.get(resultType);
        System.out.println(ladderResult.prize());
    }

    private void printResultAll(Map<String, LadderResult> ladderResults) {
        ladderResults.keySet()
                .forEach(name -> System.out.println(name + " : " + ladderResults.get(name).prize()));
    }
}
