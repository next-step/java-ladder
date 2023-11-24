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

        System.out.println(stringBuffer);
    }

    private void printHeader(PlayLadder playLadder, StringBuffer stringBuffer) {
        playLadder.players()
                .stream()
                .forEach(player -> {
                    stringBuffer.append(ladderHeader(player.name(), playLadder.nameLengthMax()));
                });
    }

    private String ladderHeader(String name, long nameLengthMax) {
        return StringUtils.leftPad(name, nameLengthMax + 1, " ");
    }

    private void createBody(PlayLadder playLadder, StringBuffer stringBuffer) {
        String onPath = DASH.repeat((int)playLadder.nameLengthMax());
        String offPath = BLANK.repeat((int)playLadder.nameLengthMax());

        playLadder.ladder()
                .stream()
                .forEach(line -> {
                    stringBuffer.append(offPath + "|");
                    line.paths()
                            .stream()
                            .forEach(path -> {
                                stringBuffer.append(createPath(path, onPath, offPath)).append("|");
                            });
                    stringBuffer.append("\n");
                });
    }

    private String createPath(Boolean path, String onPath, String offPath) {
        return path ? onPath : offPath;
    }
}
