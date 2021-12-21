package ladder.UI;

import ladder.domain.ladder.InputLadderResult;
import ladder.domain.ladder.LadderContext;
import ladder.domain.ladder.LadderResult;
import ladder.domain.user.Name;
import ladder.domain.user.Participants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String FIRST_LINE = "|";
    private static final String LINE = "-----|";
    private static final String NO_LINE = "     |";

    private static final int NAME_BOX_SIZE = 6;
    private static final String NAME_BOX_BLANK = " ";

    public static void printLadderGame(ResponseDto responseDto) {
        View.newLine();
        System.out.println("실행결과");

        printParticipants(responseDto.getParticipants().get());
        printLadder(responseDto.getLadderContext());
        printInputLadderResult(responseDto.getInputLadderResult());
    }

    private static void printParticipants(List<Name> participants) {
        participants.stream()
                .map(Name::toString)
                .forEach(name -> {
                    System.out.print(name);
                    int nameLength = NAME_BOX_SIZE - name.length();
                    printBlank(nameLength);
                });
        View.newLine();
    }

    private static void printBlank(int nameLength) {
        for (int i = 0; i < nameLength; i++) {
            System.out.print(NAME_BOX_BLANK);
        }
    }

    private static void printLadder(LadderContext ladderContext) {
        int ladderHeight = ladderContext.ladderHeight();
        for (int ladderIndex = 0; ladderIndex < ladderHeight; ladderIndex++) {
            printLadder(ladderContext, ladderIndex);
        }

    }

    private static void printLadder(LadderContext ladderContext, int ladderIndex) {
        int lineSize = ladderContext.lineSize();
        StringBuilder sb = new StringBuilder(FIRST_LINE);
        for (int lineIndex = 0; lineIndex < lineSize - 1; lineIndex++) { // 라인 크기
            sb.append(getLine(ladderContext.isRight(ladderIndex, lineIndex)));
        }
        System.out.println(sb);
    }

    private static String getLine(boolean point) {
        if (point) {
            return LINE;
        }
        return NO_LINE;
    }

    private static void printInputLadderResult(InputLadderResult inputLadderResult) {
        inputLadderResult.getResults().stream()
                .map(String::toString)
                .forEach(result -> {
                    System.out.print(result);
                    printBlank(NAME_BOX_SIZE - result.length());
                });
        View.newLine();
    }

    public static void printLadderGameResult(LadderResult ladderResult, String name) {
        View.newLine();
        System.out.println("실행결과");

        Map<String, String> result = ladderResult.getResults(name);
        for (String key : result.keySet()) {
            System.out.println(key + " : " + result.get(key));
        }
    }
}
