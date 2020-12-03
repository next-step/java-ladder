package ladder;

import ladder.DTO.LadderDTO;
import ladder.ladderexceptions.InvalidLadderHeightException;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Ladder {

    List<HorizontalLine> layer;

    public Ladder(int height, int numUsers) {
        if (height < 1) {
            throw new InvalidLadderHeightException();
        }

        this.layer = IntStream.range(0, height)
                .mapToObj(x -> HorizontalLine.of(numUsers - 1))
                .collect(toList());
    }

    public Ladder(List<HorizontalLine> lines) {
        this.layer = lines;
    }

    public void shuffle() {
        HowToConnect strategy = new RandomConnection();

        for (HorizontalLine line : layer) {
            line.shuffle(strategy);
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
