package ladder.UI;

import ladder.domain.ladder.LadderContext;
import ladder.domain.user.Name;
import ladder.domain.user.Participants;

import java.util.List;

public class ResultView {

    private static final String FIRST_LINE = "|";
    private static final String LINE = "-----|";
    private static final String NO_LINE = "     |";

    private static final int NAME_BOX_SIZE = 6;
    private static final String NAME_BOX_BLANK = " ";

    public static void printLadderGameResult(ResponseDto responseDto) {
        View.newLine();
        System.out.println("실행결과");

        Participants participants = responseDto.getParticipants();
        LadderContext ladderContext = responseDto.getLadderContext();

        printParticipants(participants.get());
        printLadder(ladderContext);
    }

    private static void printParticipants(List<Name> participants) {
        StringBuilder sb = new StringBuilder();
        for (Name name : participants) {
            sb.append(name);
            int nameLength = NAME_BOX_SIZE - name.toString().length();
            if (nameLength > 0) {
                for (int i = 0; i < nameLength; i++) {
                    sb.append(NAME_BOX_BLANK);
                }
            }
        }
        System.out.println(sb);
    }

    private static void printLadder(LadderContext ladderContext) {
        int ladderHeight = ladderContext.ladderHeight();
        int lineSize = ladderContext.lineSize();

        for (int i = 0; i < ladderHeight; i++) { // 사다리 높이
            StringBuilder sb = new StringBuilder(FIRST_LINE);
            for (int j = 0; j < lineSize - 1; j++) { // 라인 크기
                sb.append(getLine(ladderContext.isRight(i, j)));
            }
            System.out.println(sb);
        }
    }

    private static String getLine(boolean point) {
        if (point) {
            return LINE;
        }
        return NO_LINE;
    }
}
