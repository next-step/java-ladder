package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> inputPlayerNames() {
        System.out.println(ViewMessages.INSTRUCTION_PLAYER_NAMES);
        String[] inputPlayerNames = SCANNER.nextLine().split(ViewMessages.COMMA);
        return Arrays.stream(inputPlayerNames)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<String> inputGamePrizeNames() {
        System.out.println(ViewMessages.INSTRUCTION_GAME_PRIZE_NAMES);
        String[] inputGamePrizeNames = SCANNER.nextLine().split(ViewMessages.COMMA);
        return Arrays.stream(inputGamePrizeNames)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        System.out.println(ViewMessages.INSTRUCTION_LADDER_HEIGHT);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String inputResultPlayerName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }
}
