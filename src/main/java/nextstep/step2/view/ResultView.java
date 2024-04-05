package nextstep.step2.view;

import nextstep.step2.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ResultView {

    public static void printHumans(Entries entries) {
        StringBuilder sb = new StringBuilder();
        for (Participant participant : entries.getParticipantList()) {
            String name = participant.getName();
            int paddingLength = 6 - name.length();
            sb.append(" ".repeat(Math.max(0, paddingLength)));
            sb.append(name);
        }
        System.out.println(sb);
    }

    public static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        int height = lines.isEmpty() ? 0 : lines.get(0).getPoints().size();

        for (int i = 0; i < height; i++) {
            printRow(lines, i);
        }
    }

    private static void printRow(List<Line> lines, int rowIndex) {
        StringBuilder sb = new StringBuilder();
        sb.append("     ");
        for (Line line : lines) {
            sb.append("|");
            List<Boolean> points = line.getPoints();
            sb.append(points.get(rowIndex) ? "-----" : "     ");
        }
        System.out.println(sb);
    }

    public static void printResults(Results results) {
        StringBuilder sb = new StringBuilder();
        List<String> resultList = results.getResults();
        for (String result : resultList) {
            int paddingLength = 6 - result.length();
            sb.append(" ".repeat(Math.max(0, paddingLength)));
            sb.append(result);
        }
        System.out.println(sb);
    }


    public static void printGameResults(GameResult gameResult) {
        Scanner scanner = new Scanner(System.in);
        String name;
        while (true) {
            System.out.print("결과를 보고 싶은 사람은? ");
            name = scanner.nextLine();
            if (name.equalsIgnoreCase("all")) {
                printAllResults(gameResult);
                break;
            }
            printSingleResult(gameResult, name);
        }
    }

    private static void printAllResults(GameResult gameResult) {
        Map<String, String> allResults = gameResult.getAllResults();
        System.out.println("실행 결과");
        for (Map.Entry<String, String> entry : allResults.entrySet()) {
            String name = entry.getKey();
            String result = entry.getValue();
            System.out.println(name + " : " + result);
        }
    }

    private static void printSingleResult(GameResult gameResult, String name) {
        System.out.println("실행 결과");
        String result = gameResult.getResult(name);
        System.out.println(name + " : " + result);
    }
}
