package nextstep.ladder.application;

import nextstep.ladder.domain.ladder.Ladder;

import java.util.List;

public class PlayLadder {

    public static Ladder createLadder(List<String> names, int height) {
        return new Ladder(height, names.size());
    }
}
