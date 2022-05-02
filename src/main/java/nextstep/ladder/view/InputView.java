package nextstep.ladder.view;

import nextstep.common.Assert;
import nextstep.ladder.model.CommaSeparator;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public final class InputView {

    private static final String PARTICIPANTS_NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String RESULTS_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String MAXIMUM_LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_TARGET_INPUT_MESSAGE = "결과를 보고 싶은 사람은?";

    private final PrintStream guidePrinter;
    private final Scanner scanner;

    private InputView(Scanner scanner, PrintStream guidePrinter) {
        Assert.notNull(scanner, "scanner must not be null");
        Assert.notNull(guidePrinter, "guidePrinter must not be null");
        this.scanner = scanner;
        this.guidePrinter = guidePrinter;
    }

    public static InputView of(Scanner scanner, PrintStream output) {
        return new InputView(scanner, output);
    }

    public List<String> participants() {
        guidePrinter.println(PARTICIPANTS_NAME_INPUT_MESSAGE);
        return CommaSeparator.from(scanner.next()).strings();
    }

    public List<String> results() {
        guidePrinter.println(RESULTS_INPUT_MESSAGE);
        return CommaSeparator.from(scanner.next()).strings();
    }

    public String resultTarget() {
        guidePrinter.println(RESULT_TARGET_INPUT_MESSAGE);
        return scanner.next();
    }

    public int ladderHeight() {
        guidePrinter.println(MAXIMUM_LADDER_HEIGHT_INPUT_MESSAGE);
        return scanner.nextInt();
    }
}

