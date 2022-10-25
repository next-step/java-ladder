package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.User;

public class OutputView {

    public void printResult(Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();

        printName(ladder);
        for (int i = 0; i < ladder.getHeight(); i++) {
            printLadder(ladder.getLine(i), ladder.getCountOfPerson());
        }
    }

    private void printName(Ladder ladder) {
        for (int i = 0; i < ladder.getCountOfPerson(); i++) {
            System.out.print(ladder.getUserName(i));
            printSpace(ladder.getUserName(i).length());
        }
        System.out.println();
    }

    private void printSpace(int nameLength) {
        for (int i = 0; i < User.MAX_NAME_LENGTH - nameLength; i++) {
            System.out.print(" ");
        }
    }

    private void printLadder(Line line, int countOfPerson) {
        for (int i = 0; i < countOfPerson; i++) {
            printPoint(line.existPoint(i), i == countOfPerson - 1);
        }
    }

    private void printPoint(Boolean existPoint, boolean isLastIdx) {
        if (isLastIdx) {
            System.out.println("|");
            return;
        }

        System.out.print("|");
        for (int i = 0; i < User.MAX_NAME_LENGTH; i++) {
            printBar(existPoint);
        }
    }

    private void printBar(boolean existPoint) {
        if (existPoint) {
            System.out.print("-");
            return;
        }
        System.out.print(" ");
    }
}
