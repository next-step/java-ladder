package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final LadderData ladderData;
    private final List<Line> lineList = new ArrayList<>();

    public Ladder(LadderData ladderData) {
        this.ladderData = ladderData;
        makeLadder();
    }

    private void makeLadder() {

        int nameLength = ladderData.getNames().length();

        for (int i = 0; i < ladderData.getHeight(); i++) {
            Line line = new Line(nameLength, RandomSingleton::nextBoolean);
            lineList.add(line);
        }
    }

    public List<String> getParticipants() {
        return ladderData.getNames().getNameList();
    }

    public List<String> getLadderString() {
        return lineList.stream()
                .map(line -> lineToString(line.getLineList()))
                .collect(Collectors.toList());
    }

    private String lineToString(List<String> line) {
        return String.join("", line);
    }
}
