package nextstep.ladder.view;

import nextstep.ladder.utils.StringUtils;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputPlayerNames() {
        return StringUtils.splitWithComma(SCANNER.nextLine());
    }

    public static int inputLadderHeight() {
        return SCANNER.nextInt();
    }

}
