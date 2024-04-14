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
        return inputLineToList(NAME_SEPARATOR);
    }

    public static int inputLadderHeight() {
        printMessage(INPUT_LADDER_HEIGHT);
        return scanner.nextInt();
    }

    private static List<String> inputLineToList(String regex) {
        return Arrays.stream(scanner.nextLine().split(regex))
            .collect(Collectors.toList());
    }

}
