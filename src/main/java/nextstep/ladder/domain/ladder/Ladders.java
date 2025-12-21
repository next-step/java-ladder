package nextstep.ladder.domain.ladder;

import java.util.List;

public class Ladders {

    private final List<Ladder> ladders;
    private final Integer height;

    public Ladders(List<Ladder> ladders, Integer height) {
        this.ladders = ladders;
        this.height = height;
    }

    public void createLadders() {

    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public Integer getHeight() {
        return height;
    }
}
