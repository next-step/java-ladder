package ladder.view;

import ladder.domain.Participant;
import ladder.domain.ParticipantList;
import ladder.domain.ladderMap.LadderMap;
import ladder.domain.ladderMap.Line;
import ladder.domain.ladderMap.Plane;

public class ResultView {

    public void printLadderMap(LadderMap ladderMap) {
        System.out.println("실행 결과");

        String parsedNames = parsedNames(ladderMap.participantList());
        System.out.println(parsedNames);

        printPlane(ladderMap.plane());
    }

    private void printPlane(Plane plane) {
        for (Line line : plane.lines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {

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
        if (participantNameLength == Participant.MAX_LENGTH) {
            return participant.name();
        }
        StringBuilder blackSpace = new StringBuilder();
        for (int count = 0; count < Participant.MAX_LENGTH - participantNameLength; count++) {
            blackSpace.append(" ");
        }
        blackSpace.append(participant.name());
        return String.valueOf(blackSpace);
    }
}
