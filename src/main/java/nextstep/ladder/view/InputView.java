package nextstep.ladder.view;

import nextstep.ladder.utils.Splitter;
import nextstep.ladder.utils.StringUtils;

import java.util.Scanner;

import static nextstep.ladder.view.MyPrinter.lineChange;
import static nextstep.ladder.view.MyPrinter.printLine;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static String[] playerNames() {
        printLine(Announcements.PLAYER_NAMES);

        final String[] names = Splitter.byComma(StringUtils.removeSpace(SCANNER.nextLine()));

        lineChange();

        return names;
    }

    public static int ladderHeight() {
        printLine(Announcements.LADDER_HEIGHT);
        return nextIntAndRemoveLineChange();
    }

    private static int nextIntAndRemoveLineChange() {
        final int input = SCANNER.nextInt();
        SCANNER.nextLine();
        lineChange();
        return input;
    }

    private static abstract class Announcements {
        static final String PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
        static final String LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    }
}
