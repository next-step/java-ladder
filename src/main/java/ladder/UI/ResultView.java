package ladder.UI;

import ladder.domain.ladder.LadderContext;
import ladder.domain.user.Name;
import ladder.domain.user.Participants;

import java.util.List;

public class ResultView {

    private static final String LINE = "-----|";
    private static final String NO_LINE = "     |";

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
            int nameLength = 6 - name.toString().length();
            if (nameLength > 0) {
                for (int i = 0; i < nameLength; i++) {
                    sb.append(" ");
                }
            }
        }
        System.out.println(sb);
    }

    private static void printLadder(LadderContext ladderContext) {
        int ladderHeight = ladderContext.ladderHeight();
        int lineSize = ladderContext.lineSize();

        for (int i = 0; i < ladderHeight; i++) { // 사다리 높이
            StringBuilder sb = new StringBuilder("|");
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
