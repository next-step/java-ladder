package ladder.view.input;

import java.util.List;

public class DefaultInputView implements InputView {
    private static final String MESSAGE_USER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private CommandLineReader commandLineReader = new CommandLineReader();

    @Override
    public List<String> getUserNames() {
        System.out.println(MESSAGE_USER_NAMES);
        return commandLineReader.readCsv();
    }

    @Override
    public Long getLadderHeight() {
        System.out.println(MESSAGE_LADDER_HEIGHT);
        return commandLineReader.readNumber();
    }

}
