package ladder.domain;

import ladder.ui.Input;
import ladder.ui.Output;

public class LadderData {

    public static final String MSG_INPUT_PARTICIPANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String MSG_INPUT_LADDER_SIZE = "최대 사다리 높이는 몇 개인가요?";

    private final Input input;
    private final Output output;

    private Participant participant;
    private int height;

    public LadderData(Input input, Output output) {
        this.input = input;
        this.output = output;
        inputNames();
        inputHeight();
    }

    public void inputNames() {
        output.print(MSG_INPUT_PARTICIPANTS);
        String inputNames = input.nextLine();
        participant = new Participant(inputNames);
    }

    public void inputHeight() {
        output.print(MSG_INPUT_LADDER_SIZE);
        height = input.nextInt();
    }

    public Participant getNames() {
        return participant;
    }

    public int getHeight() {
        return height;
    }
}
