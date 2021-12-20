package ladder.domain.ladder;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private final List<HorizontalLine> lines;
    private final int numberOfParticipant;

    public Ladder(List<HorizontalLine> lines, int numberOfParticipant) {
        this.lines = lines;
        this.numberOfParticipant = numberOfParticipant;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return numberOfParticipant == ladder.numberOfParticipant && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines, numberOfParticipant);
    }
}
