package ladder.domain;

import ladder.domain.rule.PositionGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderGenerator {

    private final PositionGenerator positionGenerator;

    LadderGenerator(PositionGenerator positionGenerator) {
        this.positionGenerator = positionGenerator;
    }

    Ladder generate(int ladderHeight, int numberOfParticipant) {
        List<HorizontalLine> lines = new ArrayList<>();
        LineGenerator lineGenerator = new LineGenerator();
        for (int i = 0; i < ladderHeight; i++) {
            HorizontalLine line = lineGenerator.generate(numberOfParticipant, positionGenerator);
            lines.add(line);
        }
        return new Ladder(lines, numberOfParticipant);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGenerator that = (LadderGenerator) o;
        return Objects.equals(positionGenerator, that.positionGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionGenerator);
    }
}
