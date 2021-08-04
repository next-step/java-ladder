package nextstep.ladder.view;

import java.util.Scanner;
import java.util.function.Function;
import nextstep.ladder.view.exception.InvalidParseInputToIntegerException;

public class InputView {

    private static final Function<String, String> playerNamesAssist = string ->
        (string.isEmpty()) ? "pobi,honux,crong,jk,hyune" : string;

    private static final Function<String, String> resultAssist = string ->
        (string.isEmpty()) ? "꽝,5000,꽝,3000,꽝" : string;

    private static final Function<String, String> ladderHeightAssist = string ->
        (string.isEmpty()) ? "10" : string;

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputPlayerName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return playerNamesAssist.apply(scanner.nextLine());
    }

    public static String inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        return resultAssist.apply(scanner.nextLine());
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        final String input = ladderHeightAssist.apply(scanner.nextLine());

        return parseInteger(input);
    }

    private static int parseInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (final NumberFormatException ex) {
            throw new InvalidParseInputToIntegerException();
        }
    }
}
