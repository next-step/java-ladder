package ladder;

import ladder.DTO.LadderDTO;
import ladder.ladderexceptions.InvalidLadderHeightException;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Ladder {

    private static final int MINIMUM_LADDER_HEIGHT = 1;

    List<HorizontalLine> layer;

    public Ladder(int height, int numLines) {
        validateHeight(height);

        this.layer = IntStream.range(0, height)
                .mapToObj(x -> HorizontalLine.ofLineCounts(numLines))
                .collect(toList());
    }

    private void validateHeight(int height) {
        if (height < MINIMUM_LADDER_HEIGHT) {
            throw new InvalidLadderHeightException();
        }
    }

    public Ladder(List<HorizontalLine> lines) {
        this.layer = lines;
    }

    public void shuffle() {
        HowToConnect connectionMode = new RandomConnectionMode();
        shuffle(connectionMode);
    }

    public void shuffle(HowToConnect connectionMode) {
        for (HorizontalLine line : layer) {
            line.shuffle(connectionMode);
        }
    }

    public LadderDTO exportData() {
        List<List<Boolean>> layout = this.layer.stream()
                .map(HorizontalLine::getLine)
                .collect(toList());

        return new LadderDTO(layout);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(layer, ladder.layer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(layer);
    }
}
