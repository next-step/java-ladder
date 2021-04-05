package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Link;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> players() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public static int height() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    public static void printPlayers(List<String> players) {
        players.forEach(player -> System.out.printf("%6s", player));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.line().forEach(View::printLine);
    }

    public static void printLine(Line line) {
        System.out.print("     ");
        line.link().forEach(View::printLink);
        System.out.print("|\n");
    }

    public static void printLink(Link link) {
        String linkSymbol = "|-----";
        if (link == Link.OPEN) {
            linkSymbol = "|     ";
        }
        System.out.print(linkSymbol);
    }
}
