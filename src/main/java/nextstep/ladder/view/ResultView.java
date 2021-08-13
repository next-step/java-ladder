package nextstep.ladder.view;

import nextstep.ladder.domain.Goods;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.Point;
import nextstep.ladder.utils.Constants;

public class ResultView {
    private static final String IS_LINE = "----";
    private static final String NONE_LINE = "    ";
    private static final String STICK = "|";

    public static void printName(Names ladderNames) {
        ladderNames.getLadderNames().forEach(System.out::print);
        System.out.println();
    }

    public static void printLadder(Lines lines) {
        StringBuilder ladders = new StringBuilder();

        for (Line line : lines.getLines()) {
            drawLine(ladders, line);
            ladders.append(System.lineSeparator());
        }

        System.out.print(ladders);
    }

    private static void drawLine(StringBuilder ladders, Line line) {
        for(Point point : line.getPoints()) {
            ladders.append(isLeft(point.isLeft()));
            ladders.append(STICK);
        }
    }

    private static String isLeft(boolean left) {
        if(left) {
            return IS_LINE;
        }
        return NONE_LINE;
    }

    public static void printGoods(Goods goods) {
        goods.getGoods().forEach(result -> {
            System.out.print(result + Constants.SPACE);
        });
    }
}
