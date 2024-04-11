package ladder.domain;

import ladder.domain.factory.RowFactory;
import ladder.domain.vo.LadderBody;
import ladder.domain.vo.Rows;
import ladder.util.RandomBooleanGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Players players;
    private final Destinations destinations;
    private final LadderBody ladderBody;

    public Ladder(Players players,
                  Destinations destinations,
                  LadderBody ladderBody) {
        this.players = players;
        this.destinations = destinations;
        this.ladderBody = ladderBody;
    }

    public Players players() {
        return players;
    }

    public Destinations destinations() {
        return destinations;
    }

    public LadderBody ladderBody() {
        return ladderBody;
    }

    public int width(){
        return ladderBody.width();
    }

    public int height(){
        return ladderBody.height();
    }
}