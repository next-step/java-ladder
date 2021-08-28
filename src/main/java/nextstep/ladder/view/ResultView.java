package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Ladders;
import nextstep.ladder.domain.participant.Participant;
import nextstep.ladder.domain.participant.Participants;

import java.util.stream.Collectors;

public class ResultView {

    private static final String PADDING = " ";

    private static final int WIDTH = 5;
    private static final String LADDER_UNIT = "|";
    private static final String LADDER_CONNECT_UNIT = "-";

    public void printResult(Participants participants, Ladders ladders) {
        printParticipants(participants);
        printLadders(ladders);
    }

    private void printParticipants(Participants participants) {
        String participantsName = getParticipantsName(participants);
        print(participantsName);
    }

    private String getParticipantsName(Participants participants) {
        return participants.stream()
                .map(Participant::getName)
                .map(this::addPadding)
                .collect(Collectors.joining(" "));
    }

    private String addPadding(String name) {
        StringBuilder sb = new StringBuilder();
        if (name.length() < 5) {
            int paddingCount = 5 - name.length();
            addPadding(sb, paddingCount);
            sb.append(name);
        }

        return sb.toString();
    }

    private void addPadding(StringBuilder sb, int paddingCount) {
        for (int i = 0; i < paddingCount; i++) {
            sb.append(PADDING);
        }
    }

    private void printLadders(Ladders ladders) {
        int level = ladders.getLevel();
        for (int height = 0; height < level; height++) {
            printLadders(ladders, height);
        }
    }

    private void printLadders(Ladders ladders, int height) {
        StringBuilder sb = new StringBuilder();
        addPadding(sb, WIDTH);
        ladders.stream().forEach(ladder -> append(height, sb, ladder));
        sb.append(LADDER_UNIT);
        print(sb.toString());
    }

    private void append(int height, StringBuilder sb, Ladder ladder) {
        sb.append(LADDER_UNIT);
        if (ladder.isConnected(height)) {
            addConnectLine(sb);
            return;
        }

        addPadding(sb, WIDTH);
    }

    private void addConnectLine(StringBuilder sb) {
        for (int i = 0; i < WIDTH; i++) {
            sb.append(LADDER_CONNECT_UNIT);
        }
    }

    private void print(String content) {
        System.out.println(content);
    }

}
