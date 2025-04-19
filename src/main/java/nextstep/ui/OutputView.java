package nextstep.ui;

import nextstep.ladder.Ladder;
import nextstep.ladder.Lines;
import nextstep.ladder.Players;
import nextstep.ladder.Report;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OutputView {

    public static void printResult(Ladder ladder, List<String> results) {
        System.out.println("실행 결과");
        printPlayer(ladder.getPlayers());
        printLine(ladder.getLines());
        printResults(results);
    }

    private static void printPlayer(Players players) {
        var playerNamesString = String.join("  ", players.getPlayersNames());
        System.out.println(playerNamesString);
    }

    private static void printLine(Lines lines) {
        lines.getLines().forEach(line -> {
            String lineString = line.getPoints().stream()
                    .map(point -> point ? "-----" : "     ")
                    .collect(Collectors.joining("|", "|", "|"));
            System.out.println(lineString);
        });
    }

    private static void printResults(List<String> results) {
        System.out.println(String.join("  ", results));
    }

    public static void searchResult(Report report) {
        while (true) {
            System.out.println("결과를 보고 싶은 사람은? (종료하려면 'exit' 입력)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if ("all".equalsIgnoreCase(input)) {
                System.out.println("실행 결과");
                report.getResult().forEach((key, value) -> System.out.println(key + " : " + value));
            } else if (report.containsName(input)) {
                System.out.println("실행 결과");
                System.out.println(report.findResultByName(input));
            } else {
                System.out.println("존재하지 않는 이름입니다. 다시 입력해주세요.");
            }
        }
    }
}
