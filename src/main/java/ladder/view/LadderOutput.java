package ladder.view;

import ladder.Line;
import ladder.Participant;

import java.util.List;
import java.util.stream.Collectors;

public class LadderOutput {

    private List<Line> lines;
    private List<Participant> participants;
    private static final String LINE_CONNECTION = "-----";
    private static final String EMPTY_SPACE = "     ";
    private static final String SPACE = " ";
    private static final String LINE = "|";

    public LadderOutput(List<Line> lines, List<Participant> participants) {
        this.lines = lines;
        this.participants = participants;
    }

    public void printLadder() {
        int maxWidth = participants.stream()
                .map(participant -> participant.getParticipant().length())
                .max(Integer::compare)
                .orElse(0);

        // 참가자 이름 출력
        printParticipantName(maxWidth);

        // 사다리 출력
        printLinesLadder(maxWidth);
    }

    private void printParticipantName(int maxWidth) {
        String header = participants.stream()
                .map(participant -> SPACE + participant + SPACE.repeat(maxWidth - participant.getParticipant().length()))
                .collect(Collectors.joining());
        System.out.println(header);
    }

    private void printLinesLadder(int maxWidth) {
        for (Line line : lines) {
            printLine(maxWidth, line);
        }
    }

    private void printLine(int maxWidth, Line line) {
        StringBuilder lineOutput = new StringBuilder();
        lineOutput.append(SPACE.repeat(maxWidth));

        for (int j = 0; j < participants.size(); j++) {
            lineOutput.append(LINE);

            boolean isLineDraw = j < participants.size() - 1 && Boolean.TRUE.equals(line.lineStatus(j));
            lineOutput.append(isLineDraw ? LINE_CONNECTION : EMPTY_SPACE);
        }

        System.out.println(lineOutput);
    }

}
