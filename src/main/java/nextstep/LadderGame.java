package nextstep;

import nextstep.domain.Ladder;
import nextstep.domain.Lines;

import java.util.List;
import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String names = createField("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)", scanner);
        String height = createField("최대 사다리 높이는 몇 개인가요?", scanner);

        printResult(names, height);

    }

    private static String createField(String message, Scanner scanner) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private static void printNames(List<String> name) {
        name.forEach(item -> {
            System.out.printf(item + " ");
        });
    }

    private static void printLadder(Ladder ladder) {
        List<String> lines = ladder.getLines();
        lines.forEach(item -> System.out.println(item));
    }

    private static void printResult(String names, String height) {
        Ladder ladder = new Ladder(names, Integer.valueOf(height));
        List<String> name = ladder.getNames();
        printNames(name);
        System.out.println();

        printLadder(ladder);
    }
}
