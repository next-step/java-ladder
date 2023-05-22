package ladder.domain.model;

import ladder.domain.model.strategy.CheckConnect;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    List<Line> lines;

    public Lines(int personCount, int ladderHeight) {
        lines = IntStream.range(0, ladderHeight)
                .mapToObj(i -> {
                    Line line = new Line();
                    line.calculatorLine(personCount);
                    return line;
                })
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public void getConnectNumber(Player player) {
        for (int i = 0; i < lines.size(); i++) { // 0 , 1, 2
            lines.get(i)
                    .getConnectNumber(player, new CheckConnect());
        }
    }

    @Override
    public String toString() {
        return "LadderGame{" +
                "lines=" + lines +
                '}';
    }
}
