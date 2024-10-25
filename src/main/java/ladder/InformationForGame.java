package ladder;

import java.util.*;
import java.util.stream.Collectors;

public class InformationForGame {
    private String participants;
    private int ladderCount;
    private List<String> participantList = new ArrayList<>();
    private List<Line> lines;

    public InformationForGame(String participants, String ladderCount) {
        this.participants = participants;
        validForLadderCount(ladderCount);
        validForParticipant();
        initializeLines();
    }

    private void validForLadderCount(String ladderCount) {

        if (ladderCount.isBlank()) {
            throw new IllegalArgumentException("사다리 높이가 입력되지 않았습니다.");
        }

        int ladderCountForInteger = 0;

        try {
            ladderCountForInteger = Integer.parseInt(ladderCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 수는 유효한 정수여야 합니다.");
        }

        if (ladderCountForInteger <= 0) {
            throw new IllegalArgumentException("사다리 수는 양의 정수여야 합니다.");
        }

        this.ladderCount = ladderCountForInteger;
    }

    private void validForParticipant() {

        if (participants.isBlank()) {
            throw new IllegalArgumentException("참가자가 입력되지 않았습니다..");
        }

        participantList = Arrays.stream(participants.trim().split(","))
                                    .filter(participant -> participant.length() <= 5)
                                    .collect(Collectors.toList());

        if (participantList.isEmpty()) {
            throw new IllegalArgumentException("참가자가 없습니다.");
        }

    }

    private void initializeLines() {
        lines = new ArrayList<>();
        for (int i = 0; i < ladderCount; i++) {
            lines.add(new Line(participantList.size()));
        }
    }

    public void createLines() {
        for (Line line : lines) {
            line.createLine(ladderCount);
        }
    }

    public List<String> getParticipants() {
        return participantList;
    }

    public List<Line> getLines() {
        return lines;
    }
}
