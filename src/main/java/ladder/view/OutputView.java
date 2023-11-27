package ladder.view;

import ladder.domain.PlayLadder;
import ladder.utils.StringUtils;

public class OutputView {

    private static final String DASH = "-";
    private static final String BLANK = " ";

    public void printLadder(PlayLadder playLadder) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("실행결과").append("\n");
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
        String onPath = DASH.repeat((int)playLadder.lengthMax());
        String offPath = BLANK.repeat((int)playLadder.lengthMax());

        playLadder.ladder()
                .forEach(line -> {
                    stringBuffer.append(offPath).append("|");
                    line.paths()
                            .forEach(path -> stringBuffer.append(createPath(path, onPath, offPath)).append("|"));
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
}
