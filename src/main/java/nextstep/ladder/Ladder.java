package nextstep.ladder;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    ArrayList<Line> lines;

    public Ladder(int countOfPerson, int height) {
        lines = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    public Ladder(Players players, int height) {
        lines = (ArrayList<Line>) IntStream.range(0, height)
                .mapToObj(i -> new Line(players.getCount()))
                .collect(Collectors.toList());
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

}
