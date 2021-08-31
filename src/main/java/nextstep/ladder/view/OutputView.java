package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Ladders;
import nextstep.ladder.domain.ladder.line.HorizontalLines;
import nextstep.ladder.domain.participant.Participant;
import nextstep.ladder.domain.participant.Participants;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();

    private static final int PARTICIPANT_NAME_SPACE = 6;
    private static final String PARTICIPANT_NAME_PADDING = " ";

    private static final String LADDER_NOT_EXISTS_HORIZONTAL_LINE_PADDING = "     ";
    private static final String LADDER_HEIGHT_UNIT = "|";
    private static final String LADDER_HORIZONTAL_LINE = "-----";

    public void printParticipantsAndLadders(Participants participants, Ladders ladders) {
        StringBuilder stringBuilder = new StringBuilder();

        appendTitle(stringBuilder);
        appendParticipantsName(participants, stringBuilder);
        appendLadders(ladders, stringBuilder);
        print(stringBuilder.toString());
    }

    private void appendTitle(StringBuilder stringBuilder) {
        stringBuilder.append("실행결과");
        stringBuilder.append(NEW_LINE);
        stringBuilder.append(NEW_LINE);
    }

    private void appendParticipantsName(Participants participants, StringBuilder stringBuilder) {
        String paddingAddedParticipantsName = participants.stream()
                .map(Participant::getName)
                .map(this::appendNamePadding)
                .collect(Collectors.joining(""));

        stringBuilder.append(paddingAddedParticipantsName);
    }

    private String appendNamePadding(String participantName) {
        int participantNameLength = participantName.length();
        if (participantNameLength < PARTICIPANT_NAME_SPACE) {
            int paddingLength = PARTICIPANT_NAME_SPACE - participantNameLength;
            return appendPadding(participantName, paddingLength);
        }

        return participantName;
    }

    private String appendPadding(String name, int paddingLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < paddingLength; i++) {
            stringBuilder.append(PARTICIPANT_NAME_PADDING);
        }
        stringBuilder.append(name);
        return stringBuilder.toString();
    }

    private void appendLadders(Ladders ladders, StringBuilder stringBuilder) {
        List<Ladder> ladderList = ladders.stream().collect(Collectors.toList());
        Ladder ladder = ladderList.get(0);
        int maxHeight = ladder.getHeight();

        stringBuilder.append(NEW_LINE);
        for (int height = 0; height < maxHeight; height++) {
            appendLadderPerHeight(ladders, stringBuilder, height);
        }
    }

    private void appendLadderPerHeight(Ladders ladders, StringBuilder stringBuilder, int height) {
        stringBuilder.append(LADDER_NOT_EXISTS_HORIZONTAL_LINE_PADDING);
        ladders.stream().forEach((l) -> appendLadder(l, stringBuilder, height));
        stringBuilder.append(LADDER_HEIGHT_UNIT);
        stringBuilder.append(NEW_LINE);
    }

    private void appendLadder(Ladder ladder, StringBuilder stringBuilder, int index) {
        stringBuilder.append(LADDER_HEIGHT_UNIT);
        HorizontalLines horizontalLines = ladder.getHorizontalLines();
        if (horizontalLines.exist(index)) {
            stringBuilder.append(LADDER_HORIZONTAL_LINE);
            return;
        }
        stringBuilder.append(LADDER_NOT_EXISTS_HORIZONTAL_LINE_PADDING);
    }

    public void print(String content) {
        System.out.println(content);
    }

}
