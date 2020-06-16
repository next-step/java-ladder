package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private List<Draw> points = new ArrayList<>();

    public Line (int countOfPerson) {
        boolean isDraw = RandomGenerator.getRandom();
        for (int i = 1; i < countOfPerson; i++) {
            this.points.add(new Draw(isDraw));
            isDraw = (isDraw) ? false : RandomGenerator.getRandom();
        }
    }

    public int getLineCount() {
        return points.size();
    }

    public int getDrawLineCount() {
        return (int) points.stream()
                        .filter(draw -> Draw.of(true).equals(draw))
                        .count();
    }

    public String drawLine() {
        return  UI.find(Draw.of(false)).getString()
                + UI.find().getString()
                + points.stream()
                    .map(draw -> getLadderUI(draw))
                    .collect(Collectors.joining());
    }

    private String getLadderUI(Draw draw) {
        return UI.find(draw).getString() + UI.find().getString();
    }

}
