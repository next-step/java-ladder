package nextstep.ladder.view;

import java.util.Scanner;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.User;

public class OutputView {
    private static final String ALL = "all";

    public void printResult(Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();

        printName(ladder);
        for (int i = 0; i < ladder.getHeight(); i++) {
            printLadder(ladder.getLine(i), ladder.getCountOfPerson());
        }
        printResultName(ladder);
    }

    private void printName(Ladder ladder) {
        for (int i = 0; i < ladder.getCountOfPerson(); i++) {
            System.out.print(ladder.getUserName(i));
            printSpace(ladder.getUserName(i).length());
        }
        System.out.println();
    }

    private void printResultName(Ladder ladder) {
        for (int i = 0; i < ladder.getCountOfPerson(); i++) {
            System.out.print(ladder.getResultName(i));
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

    public void printUserResult(Ladder ladder) {
        String name;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("결과를 보고 싶은 사람은?");
            name = scanner.nextLine();

            System.out.println("실행 결과");
            printUserResult(name, ladder);
        } while (!ALL.equals(name));
    }

    private void printUserResult(String name, Ladder ladder) {
        if (ALL.equals(name)) {
            printAllUserResult(ladder);
            return;
        }
        System.out.println(ladder.getResult(name));
    }

    private void printAllUserResult(Ladder ladder) {
        for (int i = 0; i < ladder.getCountOfPerson(); i++) {
            System.out.println(String.format(":", ladder.getUserName(i), ladder.getResult(i)));
        }
    }
}
