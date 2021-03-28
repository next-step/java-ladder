package ladder.view;

import ladder.domain.Participant;
import ladder.domain.ParticipantList;
import ladder.domain.ladderMap.LadderMap;
import ladder.domain.ladderMap.Line;
import ladder.domain.ladderMap.Link;
import ladder.domain.ladderMap.Plane;

public class ResultView {

    private static final String BLANK = " ";
    private static final String VERTICAL_ADDED = "     |";
    private static final char HORIZONTAL = '-';

    private static final int DIVIDER = 6;
    private static final int VERTICAL_INDEX = 5;

    public void printLadderMap(LadderMap ladderMap) {
        System.out.println("실행 결과");

        String parsedNames = parsedNames(ladderMap.participantList());
        System.out.println(parsedNames);

        printPlane(ladderMap.plane());
    }

    private void printPlane(Plane plane) {
        for (Line line : plane.lines()) {
            String verticalLineAdded = addVerticalLines(line);
            String horizontalLineAdded = addHorizontalLines(verticalLineAdded, line);
            System.out.println(horizontalLineAdded);
        }
    }

    private String addHorizontalLines(String verticalLineAdded, Line line) {
        StringBuilder horizontalLineAdded = new StringBuilder(verticalLineAdded);
        for (Link link : line.links()) {
            horizontalLineAdded = addHorizontalLine(horizontalLineAdded, link);
        }
        return String.valueOf(horizontalLineAdded);
    }

    private StringBuilder addHorizontalLine(StringBuilder toAddHorizontalLine, Link link) {
        for (int count = 0; count < VERTICAL_INDEX; count++) {
            toAddHorizontalLine.setCharAt(DIVIDER + link.from() * DIVIDER + count, HORIZONTAL);
        }
        return toAddHorizontalLine;
    }

    private String addVerticalLines(Line line) {
        StringBuilder verticalLineAdded = new StringBuilder();
        for (int count = 0; count < line.points().size(); count++) {
            verticalLineAdded.append(VERTICAL_ADDED);
        }
        return String.valueOf(verticalLineAdded);
    }

    private String parsedNames(ParticipantList participantList) {
        StringBuilder parsedNames = new StringBuilder();
        for (Participant participant : participantList.participants()) {
            parsedNames.append(parsedName(participant));
        }
        return String.valueOf(parsedNames);
    }

    private String parsedName(Participant participant) {
        int participantNameLength = participant.name().length();
        StringBuilder blankSpace = new StringBuilder();
        blankSpace.append(BLANK);
        if (participantNameLength == Participant.MAX_LENGTH) {
            blankSpace.append(participant.name());
            return String.valueOf(blankSpace);
        }
        for (int count = 0; count < Participant.MAX_LENGTH - participantNameLength; count++) {
            blankSpace.append(BLANK);
        }
        blankSpace.append(participant.name());
        return String.valueOf(blankSpace);
    }
}
