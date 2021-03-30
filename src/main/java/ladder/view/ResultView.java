package ladder.view;

import ladder.entity.ladderMap.LadderMap;
import ladder.entity.ladderMap.Line;
import ladder.entity.ladderMap.Link;
import ladder.entity.participant.Participant;
import ladder.entity.participant.ParticipantList;

import java.util.List;

public class ResultView {

    private static final char BLANK = ' ';
    private static final String VERTICAL_ADDED = "     |";
    private static final char HORIZONTAL = '-';

    private static final int DIVIDER = 6;
    private static final int VERTICAL_INDEX = 5;
    private static final int MINIMUM_LENGTH = 5;

    public void printGameMap(LadderMap ladderMap) {
        System.out.println("사다리 결과");

        String parsedNames = parsedNames(ladderMap.participantList());
        System.out.println(parsedNames);

        printLadderMap(ladderMap.lines());
    }

    private void printLadderMap(List<Line> lines) {
        for (Line line : lines) {
            String verticalLineAdded = addVerticalLines(line);
            String horizontalLineAdded = addHorizontalLines(verticalLineAdded, line);
            System.out.println(horizontalLineAdded);
        }
    }

    private String addHorizontalLines(String verticalLineAdded, Line line) {
        StringBuilder horizontalLineAdded = new StringBuilder(verticalLineAdded);
        for (Link link : line.links()) {
            horizontalLineAdded = mightAddHorizontalLine(horizontalLineAdded, link);
        }
        return String.valueOf(horizontalLineAdded);
    }

    private StringBuilder mightAddHorizontalLine(StringBuilder toAddHorizontalLine, Link link){
        if(link.goesRight()){
            return addHorizontalLine(toAddHorizontalLine, link, HORIZONTAL);
        }
        return addHorizontalLine(toAddHorizontalLine, link, BLANK);
    }

    private StringBuilder addHorizontalLine(StringBuilder toAddHorizontalLine, Link link, char value) {
        for (int count = 0; count < VERTICAL_INDEX; count++) {
            toAddHorizontalLine.setCharAt(DIVIDER + link.from().index() * DIVIDER + count, value);
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
        StringBuilder parsedName = new StringBuilder();
        parsedName.append(BLANK);
        if (participantNameLength == MINIMUM_LENGTH) {
            parsedName.append(participant.name());
            return String.valueOf(parsedName);
        }
        for (int count = 0; count < MINIMUM_LENGTH - participantNameLength; count++) {
            parsedName.append(BLANK);
        }
        parsedName.append(participant.name());
        return String.valueOf(parsedName);
    }
}
