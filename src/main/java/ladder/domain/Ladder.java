package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<Participant> participantList;
    private List<Line> lineList = new ArrayList<>();
    private int height;

    public Ladder() {
    }

    public Ladder(List<Participant> participantList) {
        this.participantList = participantList;
    }

    public Ladder(List<Participant> participantList, int height) {
        this.participantList = participantList;
        this.height = height;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public List<String> getParticipantsNameList() {
        return participantList.stream().
                map(participant -> participant.getName())
                .collect(Collectors.toList());
    }

    public int getHeight() {
        return height;
    }

    public void makeLadder() {
        IntStream.rangeClosed(0, height).forEach(value -> {
            lineList.add(makeLine());
        });
    }

    private Line makeLine() {
        return new Line(participantList.size());
    }

    public List<Line> getLines() {
        return lineList;
    }
}
