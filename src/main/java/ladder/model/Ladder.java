package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    List<Line> lines;

    private Ladder(int countOfLine, int countOfParticipants) {
        this.lines = IntStream.range(0, countOfLine)
                .mapToObj(index -> Line.from(countOfParticipants))
                .collect(Collectors.toList());
    }

    public static Ladder from(int countOfLine, Participants participants) {
        return new Ladder(countOfLine, participants.size());
    }

    public List<Line> getLines() {
        // ref: https://www.baeldung.com/java-immutable-list
        return Collections.unmodifiableList(lines);
    }
}
