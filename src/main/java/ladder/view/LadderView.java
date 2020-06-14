package ladder.view;

import ladder.domain.Line;
import ladder.domain.Linetype;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderView extends TextView {

    private static final String ASK_PARTICIPANT_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_TEXT = "실행결과";
    private static final String BLANK_TEXT = " ";
    private static final int MIN_BLANK_CHECK_VALUE = 2;
    private static final int MIN_LINE_LENGTH = 3;

    @Override
    public void view(Object o) {
        super.view(o);
    }

    private void viewInLine(String text) {
        System.out.print(text);
    }

    public void printAskParticipantName() {
        view(ASK_PARTICIPANT_NAME);
    }

    public void printAskLadderHeight() {
        view(ASK_LADDER_HEIGHT);
    }

    public void printResultText() {
        view(RESULT_TEXT);
    }

    public void printLadder(List<String> participantNames, List<Line> lines) {
        printResultText();
        printParticipantNames(participantNames);

        lines.stream().forEach(line -> {
            printStartBlank(participantNames.size());
            printLineType(line, participantNames.size());
            view(BLANK_TEXT);
        });
    }

    private void printParticipantNames(List<String> participantNames) {
        participantNames.stream().forEach(name -> {
            if (participantNames.size() - name.length() > MIN_BLANK_CHECK_VALUE) {
                int blankCount = participantNames.size() - name.length();
                viewInLine(getBlankString(blankCount).concat(name));
                return;
            }
            viewInLine(BLANK_TEXT.concat(name).concat(BLANK_TEXT));
        });
        view(BLANK_TEXT);
    }

    private void printLineType(Line line, int participantCount) {
        line.getLineTypes().stream().forEach(lineType -> {
            viewInLine(getFormattedLineType(lineType.getLine(), participantCount));
        });
    }

    private String getFormattedLineType(String lineType, int participantCount) {
        if (lineType.equals(Linetype.VERTICAL.getLine())) {
            return lineType;
        }

        int lineLength = participantCount < MIN_LINE_LENGTH ? MIN_LINE_LENGTH : participantCount;

        return IntStream.rangeClosed(0, lineLength)
                .mapToObj(operand -> lineType)
                .collect(Collectors.joining());
    }

    private String getBlankString(int blankCount) {
        return IntStream.rangeClosed(0, blankCount)
                .mapToObj(operand -> BLANK_TEXT)
                .collect(Collectors.joining());
    }

    public void printStartBlank(int participantCount) {
        viewInLine(IntStream.rangeClosed(1, participantCount)
                .mapToObj(operand -> BLANK_TEXT)
                .collect(Collectors.joining()));
    }

}
