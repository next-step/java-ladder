package ladder.view;

import ladder.Line;

import java.util.List;
import java.util.stream.Collectors;

public class LadderOutput {

    private List<Line> lines;
    private List<String> participantList;
    private static final String LINE_CONNECTION = "-----";
    private static final String EMPTY_SPACE = "     ";
    private static final String SPACE = " ";
    private static final String LINE = "|";

    public LadderOutput(List<Line> lines, List<String> participantList) {
        this.lines = lines;
        this.participantList = participantList;
    }

    public void printLadder() {
        int maxWidth = participantList.stream()
                .map(String::length)
                .max(Integer::compare)
                .orElse(0);

        // 참가자 이름 출력
        printParticipantName(maxWidth);

        // 사다리 출력
        printLinesLadder(maxWidth);
    }

    private void printParticipantName(int maxWidth) {
        String header = participantList.stream()
                .map(participant -> SPACE + participant + SPACE.repeat(maxWidth - participant.length()))
                .collect(Collectors.joining());
        System.out.println(header);
    }

    private void printLinesLadder(int maxWidth) {
        for (Line line : lines) {
            StringBuilder lineOutput = new StringBuilder();
            lineOutput.append(SPACE.repeat(maxWidth));
            for (int j = 0; j < participantList.size(); j++) {
                lineOutput.append(LINE);
                lineOutput.append(j < participantList.size() - 1 && Boolean.TRUE.equals(line.getLines().get(j)) ? LINE_CONNECTION : EMPTY_SPACE);
            }
            System.out.println(lineOutput);
        }
    }
}
