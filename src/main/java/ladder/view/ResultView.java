package ladder.view;

import ladder.domain.GameResult;
import ladder.domain.Line;
import ladder.domain.Participants;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final int STANDARD_SPACE_WHEN_PRINT_NAME = 3;

    private ResultView() {
    }

    public static void printNames(List<String> names) {
        names.stream()
                .forEach(name -> printName(name));
        System.out.println();
    }

    private static void printName(String name) {
        if (name.length() > STANDARD_SPACE_WHEN_PRINT_NAME) {
            System.out.print(name + "\t");
            return;
        }
        System.out.print(name + "\t\t");
    }

    public static void printLadder(List<Line> ladder) {
        ladder.stream()
                .forEach(line -> printLine(line.getLine()));
    }

    private static void printLine(List<Boolean> line) {
        line.stream()
                .forEach(e -> drawPartOfLine(e));
        System.out.println("│");
    }

    private static void drawPartOfLine(Boolean aBoolean) {
        if (aBoolean == true) {
            System.out.print("│-------");
            return;
        }
        System.out.print("│" + "\t\t");
    }

    public static void printResult(List<String> results) {
        results.stream()
                .forEach(result -> printName(result));
        System.out.println();
    }

    public static void printResultOfGame(int index, Participants participants, GameResult gameResult) {
        if (index != -1) {
            System.out.println(gameResult.getResultOfGame(index));
            return;
        }
        printAllResultOfGame(participants, gameResult);
    }

    private static void printAllResultOfGame(Participants participants, GameResult gameResult) {
        System.out.println("실행 결과");
        for (int i = 0; i < participants.getNumberOfParticipants(); i++) {
            System.out.print(participants.getParticipant(i) + " : ");
            System.out.println(gameResult.getResultOfGame(i));
        }
    }
}
