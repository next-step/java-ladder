package view;

import com.google.common.base.Strings;
import domain.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Set;

public class ConsoleOutputView {
    public static void printResult(LadderGame ladderGame) {
        Integer maxLineSize = ladderGame.longestUserNameLength();

        printUsers(ladderGame.getUsers(), maxLineSize);
        printLadder(ladderGame.getLadder(), maxLineSize);
    }

    private static void printUsers(List<User> users, Integer maxLineSize) {
        for (User user : users) {
            System.out.print(StringUtils.rightPad(user.getName(), maxLineSize + 1));
        }
        System.out.println();
    }

    private static void printLadder(Ladder ladder, Integer maxLineSize) {
        List<Point> points = ladder.getPoints();
        Set<Line> lines = ladder.getLines();

        for (Point point : points) {
            System.out.print("|");

            if(point.getX() < ladder.getWidth()) {
                printLine(lines.contains(Line.valueOf(point, point.increaseX())), maxLineSize);
            }

            if(point.getX().equals(ladder.getWidth())) {
                System.out.println();
            }
        }
    }

    private static void printLine(boolean lineExist, Integer maxLineSize) {
        if(lineExist) {
            System.out.print(Strings.repeat("-", maxLineSize));
        } else {
            System.out.print(Strings.repeat(" ", maxLineSize));
        }
    }
}
