package ladder2.view;


import ladder.utils.StringUtils;
import ladder2.domain.LadderResult;
import ladder2.domain.PlayLadder;

import java.util.Map;

public class OutputView {

    private static final String DASH = "-";
    private static final String BLANK = " ";

    public void printLadder(PlayLadder playLadder) {
        System.out.println();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("사다리 결과").append("\n");
        printHeader(playLadder, stringBuffer);
        stringBuffer.append("\n");
        createBody(playLadder, stringBuffer);
        createFooter(playLadder, stringBuffer);

        System.out.println(stringBuffer);
    }

    private void printHeader(PlayLadder playLadder, StringBuffer stringBuffer) {
        playLadder.players()
                .forEach(player -> stringBuffer.append(fixedRow(player.name(), playLadder.lengthMax())));
    }

    private String fixedRow(String name, long nameLengthMax) {
        return StringUtils.leftPad(name, nameLengthMax + 1, " ");
    }

    private void createBody(PlayLadder playLadder, StringBuffer stringBuffer) {
        String onPath = DASH.repeat((int) playLadder.lengthMax());
        String offPath = BLANK.repeat((int) playLadder.lengthMax());


        playLadder.ladder()
                .forEach(row -> {
                    stringBuffer.append(offPath).append("|");
                    row.points().forEach(point -> {
                        if(row.points().size() -1 == row.points().indexOf(point)){
                            return;
                        }
                        stringBuffer.append(createPath(point.right(), onPath, offPath)).append("|");
                    });
                    stringBuffer.append("\n");
                });
    }

    private String createPath(Boolean path, String onPath, String offPath) {
        return path ? onPath : offPath;
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
        for (String name : ladderResults.keySet()) {
            System.out.println(name + " : " + ladderResults.get(name).prize());
        }
    }
}
