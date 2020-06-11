package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Point;

public class OutputView {

    public static void drawLadder(Ladder ladder) {
        for (String userName : ladder.getGameUserName()) {
            System.out.printf(String.format("%5s ", userName));
        }
        System.out.println();

        for (int currentPosition = 0; currentPosition < ladder.getMaxHeight(); currentPosition++) {
            StringBuilder stringBuilder = new StringBuilder("     ");
            for (int i = 0; i < ladder.size(); i++) {
                stringBuilder.append("|");
                if (ladder.getConnectionPoints(i).hasPoint(Point.of(currentPosition))) {
                    stringBuilder.append("-----");
                } else {
                    stringBuilder.append("     ");
                }
            }
            System.out.println(stringBuilder.toString());
        }

    }
}
