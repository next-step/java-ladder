package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladders {
    private List<Ladder> ladders;

    public Ladders() {
        this.ladders = new ArrayList<>();
    }

    public Ladders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public void add() {
        ladders.add(new Ladder());
    }

    public int size() {
        return ladders.size();
    }

    public void addHeight(int index, Direction direction) {
        ladders.get(index).addHeight(direction);
    }

    public int height() {
        return ladders.stream()
                .map(Ladder::height)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public Direction ladderDirection(int index, int height) {
        return ladders.get(index).getDirectionOfHeight(height);
    }
}
