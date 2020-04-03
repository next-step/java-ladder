package ladder.view;

import ladder.util.ScannerUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static ladder.util.MessageUtil.MESSAGE_INPUT_LADDER_HEIGHT;
import static ladder.util.MessageUtil.MESSAGE_INPUT_PLAYERS;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static List<String> getPlayersFromUser() {
        System.out.println(MESSAGE_INPUT_PLAYERS);
        return splitNames(ScannerUtil.readLine());
    }

    public static int getHeightFromUser() {
        System.out.println(MESSAGE_INPUT_LADDER_HEIGHT);
        return ScannerUtil.readInt();
    }

    private static List<String> splitNames(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toList());
    }
}