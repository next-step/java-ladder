package nextstep.ladder.view;

import nextstep.ladder.domain.Goods;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Position;
import nextstep.ladder.utils.Constants;

public class ResultView {
    private static final String IS_LINE = "----";
    private static final String NONE_LINE = "    ";
    private static final String STICK = "|";
    private static final int MAX_LENGTH = 4;

    public static void printNameAndLadder(Names ladderNames, Lines lines) {
        printName(ladderNames);
        printLadder(lines);
    }

    private static void printName(Names ladderNames) {
        ladderNames.getLadderNames()
            .stream().map(ResultView::addSpace)
            .forEach(System.out::print);
        System.out.println();
    }

    private static void printLadder(Lines lines) {
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
        goods.getGoods().stream().map(ResultView::addSpace)
                        .forEach(result -> System.out.print(result + Constants.SPACE));
        System.out.println();
    }

    private static String addSpace(String goods) {
        if (goods.length() >= MAX_LENGTH) {
            return goods;
        }
        return addSpace(Constants.SPACE.concat(goods));
    }

    public static int result(Lines lines, int resultIndex) {
        for (Line line : lines.getLines()) {
            Position position = Position.of(resultIndex, line.getPoints().get(resultIndex).move());
            resultIndex = position.move();
        }

        return resultIndex;
    }

    public static void lookForGoods(String goodsName) {
        executionResult();
        System.out.println(goodsName);
    }

    public static void lookForGoodsAll(String ladderName, String goodsName) {
        System.out.println(ladderName + " " + goodsName);
    }

    public static void executionResult() {
        System.out.println("실행 결과");
    }


}
