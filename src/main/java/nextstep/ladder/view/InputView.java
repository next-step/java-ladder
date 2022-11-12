package nextstep.ladder.view;

import static java.lang.System.*;

import java.util.Scanner;

import nextstep.ladder.view.dto.AskHeightOfLadderDto;
import nextstep.ladder.view.dto.AskParticipantNamesDto;

public class InputView {
    private static final Scanner SCANNER = new Scanner(in);
    private static final String PARTICIPANT_NAMES_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_OF_LADDER_QUESTION = "최대 사다리 높이는 몇 개인가요?";
    private static final String LINE_BREAK = "\n";

    public AskParticipantNamesDto askParticipantNames() {
        print(PARTICIPANT_NAMES_QUESTION);
        print(LINE_BREAK);
        return AskParticipantNamesDto.of(SCANNER.nextLine());
    }

    public AskHeightOfLadderDto askHeightOfLadder() {
        print(HEIGHT_OF_LADDER_QUESTION);
        print(LINE_BREAK);
        return AskHeightOfLadderDto.of(Integer.parseInt(SCANNER.nextLine()));
    }

    private void print(String text) {
        out.print(text);
    }
}
