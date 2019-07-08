package ladder.view.input;

import ladder.common.CommandLineReader;
import ladder.common.Csv;
import ladder.common.PositiveNumber;

public class DefaultInputView implements InputView {
    private static final String MESSAGE_USER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";

    private CommandLineReader commandLineReader = new CommandLineReader();

    @Override
    public Csv getUserNames() {
        System.out.println(MESSAGE_USER_NAMES);
        return commandLineReader.readCsv();
    }

    @Override
    public PositiveNumber getLadderHeight() {
        System.out.println(MESSAGE_LADDER_HEIGHT);
        return commandLineReader.readNumber();
    }
}
