package ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView extends View {
    private static final String ENTER_PARTICIPANT_NAME_INIT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ENTER_LADDER_HEIGHT_INIT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> enterParticipantName() {
        enterParticipantNameInitMessage();
        String namesInput = this.scanner.nextLine();
        List<String> participantNames = parseParticipantNames(namesInput);
        participantNames.forEach(this::validateName);
        printEmptyLine();
        return participantNames;
    }

    private void enterParticipantNameInitMessage() {
        System.out.println(ENTER_PARTICIPANT_NAME_INIT_MESSAGE);
    }

    private List<String> parseParticipantNames(String namesInput) {
        return new ArrayList<>(Arrays.asList(namesInput.split(",")));
    }

    private void validateName(String participantName) {
        if (participantName.length() < 1) {
            throw new IllegalArgumentException("이름은 1글자 이상이여야 합니다. 입력한 이름: " + participantName);
        }
    }

    public int enterLadderHeight() {
        enterLadderHeightInitMessage();
        String ladderHeightInput = this.scanner.nextLine();
        int ladderHeight = parseInteger(ladderHeightInput);
        validateHeight(ladderHeight);
        printEmptyLine();
        return ladderHeight;
    }

    private void enterLadderHeightInitMessage() {
        System.out.println(ENTER_LADDER_HEIGHT_INIT_MESSAGE);
    }

    private int parseInteger(String input) {
        return Integer.parseInt(input);
    }

    private void validateHeight(int ladderHeight) {
        if (ladderHeight < 1) {
            throw new IllegalArgumentException("사다리 높이는 1이상이여야 합니다. 입력한 높이: " + ladderHeight);
        }
    }
}
