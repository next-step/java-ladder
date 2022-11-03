package ladder.view;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView extends View {
    private static final String ENTER_PARTICIPANT_NAME_INIT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ENTER_WINNING_ITEMS_INIT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ENTER_LADDER_HEIGHT_INIT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_INIT_MESSAGE = "결과를 보고 싶은 사람은?";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> enterParticipantName() {
        enterParticipantNameInitMessage();
        String namesInput = this.scanner.nextLine();
        List<String> participantNames = lineStringToStrings(namesInput);
        participantNames.forEach(this::validateEmptyString);
        printEmptyLine();
        return participantNames;
    }

    public List<String> enterWinningItems(int winningItemSize) {
        System.out.println(ENTER_WINNING_ITEMS_INIT_MESSAGE);
        String winningItemsInput = this.scanner.nextLine();
        List<String> winningItems = lineStringToStrings(winningItemsInput);
        winningItems.forEach(this::validateEmptyString);
        winningItemsSizeValidate(winningItems, winningItemSize);
        printEmptyLine();
        return winningItems;
    }

    public int enterLadderHeight() {
        enterLadderHeightInitMessage();
        String ladderHeightInput = this.scanner.nextLine();
        int ladderHeight = parseInteger(ladderHeightInput);
        validateHeight(ladderHeight);
        printEmptyLine();
        return ladderHeight;
    }

    public String enterResultName() {
        System.out.println(RESULT_INIT_MESSAGE);
        String nameInput = this.scanner.nextLine();
        this.validateEmptyString(nameInput);
        printEmptyLine();
        return nameInput;
    }

    private void winningItemsSizeValidate(List<String> winningItems, int winningItemSize) {
        if (winningItems.size() != winningItemSize) {
            throw new IllegalArgumentException(MessageFormat.format(
                    "입력값 {0}개 여야 합니다. 햔제 입력값 개수: {1}",
                    winningItemSize,
                    winningItems.size()
            ));
        }
    }

    private void enterParticipantNameInitMessage() {
        System.out.println(ENTER_PARTICIPANT_NAME_INIT_MESSAGE);
    }

    private List<String> lineStringToStrings(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    private void validateEmptyString(String inputString) {
        if (inputString.length() < 1) {
            throw new IllegalArgumentException("입력값은 1글자 이상이여야 합니다. 입력한 값: " + inputString);
        }
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
