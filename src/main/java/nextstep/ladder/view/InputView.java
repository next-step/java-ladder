package nextstep.ladder.view;

import static nextstep.ladder.view.ResultView.printMessage;
import static nextstep.ladder.view.ViewConstant.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputJoinUserNames() {
        printMessage(INPUT_JOIN_USER_NAMES);
        return inputLineToList(COMMA_SEPARATOR);
    }

    public static int inputLadderHeight() {
        printMessage(INPUT_LADDER_HEIGHT);
        return scanner.nextInt();
    }

    public static List<String> inputExecuteResult(){
        printMessage(INPUT_EXECUTE_RESULT);
        return inputLineToList(COMMA_SEPARATOR);
    }

    public static String inputUserNameForResult(){
        printMessage(INPUT_USER_NAME_FOR_RESULT);
        return scanner.next();
    }

    private static List<String> inputLineToList(String regex) {
        return Arrays.stream(scanner.nextLine().split(regex))
            .collect(Collectors.toList());
    }

}
