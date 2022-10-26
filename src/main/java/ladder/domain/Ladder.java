package ladder.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<String> participantNames;
    private final List<Line> lines;

    public Ladder(List<String> participantNames, int ladderHeight, LineGenerator lineGenerator) {
        this.participantNames = participantNames;
        int lineLength = getLineLength(participantNames);
        lines = IntStream.range(0, ladderHeight)
                .mapToObj(i -> lineGenerator.create(lineLength))
                .collect(Collectors.toList());
    }

    private int getLineLength(List<String> participantNames) {
        return participantNames.size() - 1;
    }

    public int getNamesMaxLength() {
        return participantNames.stream()
                .mapToInt(String::length)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Line> getLines() {
        return lines;
    }
}
