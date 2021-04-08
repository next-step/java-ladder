package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Link;
import ladder.domain.Players;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> names() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return getStrings(",");
    }

    public static int height() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    public static List<String> resultItems() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return getStrings(",");
    }

    public static String expectedPlayer() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

    public static void printResult(Players players, Ladder ladder) {
        System.out.println("실행결과");
        printPlayer(players);
        printLadder(ladder);
    }

    private static void printPlayer(Players players) {
        printNames(players.names());
    }

    private static void printNames(List<String> players) {
        players.forEach(player -> System.out.printf("%6s", player));
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.lines().forEach(View::printLine);
    }

    private static void printLine(Line line) {
        System.out.print("     ");
        line.links().forEach(View::printLink);
        System.out.print("|\n");
    }

    private static void printLink(Link link) {
        String linkSymbol = "|-----";
        if (link == Link.OPEN) {
            linkSymbol = "|     ";
        }
        System.out.print(linkSymbol);
    }

    private static List<String> getStrings(String delimiter) {
        return Arrays.asList(scanner.nextLine().split(delimiter));
    }
}
