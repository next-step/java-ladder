package view;

import java.util.Scanner;
import java.util.List;
import domain.Players;
public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Players inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Players(parseCommaSeparatedString(scanner.nextLine()));
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return parseInt(scanner.nextLine());
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static List<String> parseCommaSeparatedString(String input) {
        try {
            return List.of(input.split(","));
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("쉼표(,)로 구분된 문자열을 입력해주세요.");
        }
    }
}
