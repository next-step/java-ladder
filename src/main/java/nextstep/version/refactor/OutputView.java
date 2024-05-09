package nextstep.version.refactor;

import nextstep.version.refactor.domain.*;

import java.util.List;
import java.util.Scanner;

public class OutputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printLadder(Participants participants, Line line, Rewards rewards) {
        println("사다리 결과");
        printNames(participants);
        println();

        Integer size = line.size();
        printLadder(line, size);
        printPrize(rewards);
    }

    private static void printPrize(Rewards rewards) {
        int size = rewards.size();
        for (int i = 0; i < size; i++) {
            System.out.print(padLeft(rewards.get(i), 5));
        }
        println();
    }

    private static void printLadder(Line line, Integer size) {
        for (int i = 0; i < size; i++) {
            Points points = line.get(i);
            int pointSize = points.size();
            createLine(pointSize, points);
        }
    }

    private static void createLine(int pointSize, Points points) {
        for (int j = 0; j < pointSize - 1; j++) {
            print("|");
            print(createLine(points, j));
        }
        println("|");
    }

    private static String createLine(Points points, int index) {
        if (points.hasLine(index)) {
            return "-----";
        }
        return "     ";
    }

    private static void print(String message) {
        System.out.print(message);
    }

    private static void printNames(Participants participants) {
        List<String> nameList = participants.getNameList();
        nameList.forEach(item -> {
            System.out.print(padLeft(item, 5) + " ");
        });
    }

    private static void println() {
        System.out.println();
    }

    private static void println(String message) {
        System.out.println(message);
    }

    public static String padLeft(String str, int targetLength) {
        return String.format("%" + targetLength + "s", str).replace(' ', ' ');
    }

    public static void printResult(LadderResult result) {
        boolean finished = false;
        do {
            println("결과를 보고 싶은 사람은?");
            String name = scanner.nextLine();
            if (name.equals("all")) {
                printAllResult(result);
                finished = true;
            } else {
                println("실행 결과");
                println(result.get(name));
                println();
            }
        } while (!finished);
    }

    private static void printAllResult(LadderResult result) {
        println("실행 결과");
        List<String> nameAndPrize = result.getNameAndPrize();
        nameAndPrize.forEach(System.out::println);
    }
}
