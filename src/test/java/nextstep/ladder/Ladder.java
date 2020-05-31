package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private List<Line> lines;

    public Ladder(int height, List<Player> players) {
        if(players.size() < 2){
            throw new IllegalArgumentException("min player is 2");
        }
        if(height < 1){
            throw new IllegalArgumentException("min height is 1");
        }

        this.lines = Stream.generate(() -> new Line(players.size()))
            .limit(height)
            .collect(Collectors.toList());
    }

    List<Line> getLines() {
        return new ArrayList<>(this.lines);
    }
}
