package laddergame.v2.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int move(int position){
        int current = position;
        for(Line line : lines){
            current = line.move(current);
        }
        return current;
    }

    public List<Integer> moveAll(int playerCount){
        return IntStream.range(0, playerCount)
                .boxed()
                .map(this::move)
                .collect(toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
