package ladder.domain.ladder;

import ladder.domain.Gamer;
import ladder.domain.ladder.maker.MakeLadderStrategy;

import java.util.List;
import java.util.stream.Collectors;

class Lines {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    static Lines of(MakeLadderStrategy makeLadderStrategy){
        return new Lines(makeLadderStrategy.makeBarLines());
    }

    List<List<Boolean>> getRawMatrix() {
        return lines.stream()
                .map(Line::getBarExists)
                .collect(Collectors.toList());
    }

    LadderNumber getResultNumber(Gamer gamer) {
        LadderNumber ladderNumber = gamer.getLadderNumber();
        for (Line line : lines) {
            ladderNumber = line.move(ladderNumber);
        }
        return ladderNumber;
    }

    int width() {
        return lines.get(0).size();
    }
}
