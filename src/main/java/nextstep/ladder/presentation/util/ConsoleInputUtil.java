package nextstep.ladder.presentation.util;

import java.util.Scanner;

import static nextstep.ladder.presentation.PromptMessage.*;

public class ConsoleInputUtil {
    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleInputUtil() {
    }

    public static String askParticipantNames() {
        System.out.println(PARTICIPANTS_NAMES_QUESTION_MESSAGE.message());
        return SCANNER.nextLine();
    }

    public static int askMaximumLadderHeight() {
        System.out.println(MAXIMUM_LADDER_HEIGHT_QUESTION_MESSAGE.message());
        return SCANNER.nextInt();
    }
}
