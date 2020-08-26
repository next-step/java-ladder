package ladder.domain;

import ladder.ui.Input;
import ladder.ui.Output;

import java.util.List;

public class LadderData {

    private static final String MSG_INPUT_PARTICIPANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MSG_INPUT_LADDER_SIZE = "최대 사다리 높이는 몇 개인가요?";

    private Participant participant;
    private int height;

    public LadderData(Input input, Output output) {
        inputNames(input, output);
        inputHeight(input, output);
    }

    private void inputNames(Input input, Output output) {
        output.print(MSG_INPUT_PARTICIPANTS);
        String inputNames = input.nextLine();
        participant = new Participant(inputNames);
    }

    private void inputHeight(Input input, Output output) {
        output.print(MSG_INPUT_LADDER_SIZE);
        height = input.nextInt();
    }

    public List<String> getParticipantNames() {
        return participant.getNames();
    }

    public int getParticipantsCount() {
        return participant.getNames().size();
    }

    public int getHeight() {
        return height;
    }
}
