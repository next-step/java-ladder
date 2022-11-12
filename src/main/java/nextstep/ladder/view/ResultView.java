package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Line;

public class ResultView {

    private ResultView() {}

    public static void printLadderGame(LadderGame ladderGame) {
        System.out.println("\n실행결과\n");
        System.out.println(getLadderGameString(ladderGame));
    }

    private static String getLadderGameString(LadderGame ladderGame) {
        StringBuilder stringBuilder = new StringBuilder();
        ladderGame.getNames().forEach(name -> stringBuilder.append(String.format("%6s", name)));
        return stringBuilder.append("\n").append(getLadderString(ladderGame.getLadder())).toString();
    }

    private static String getLadderString(Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        ladder.getLines().forEach(line -> stringBuilder.append(getLineString(line)).append("\n"));
        return stringBuilder.toString();
    }

    private static String getLineString(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("     ");
        for (int i = 0; i < line.getPointSize() - 1; i++) {
            stringBuilder.append("|");
            stringBuilder.append(getLineConnectionString(line, i, i + 1));
        }
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    private static String getLineConnectionString(Line line, int leftIndex, int rightIndex) {
        if (line.getPoint(leftIndex) && line.getPoint(rightIndex)) {
            return "-----";
        } else {
            return "     ";
        }
    }

}
