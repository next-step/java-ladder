package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderPlayers {

    public static final int MIN_COUNT_OF_PERSON = 2;

    private final List<Name> values;

    public LadderPlayers(List<Name> values) {
        if (values.size() < MIN_COUNT_OF_PERSON) {
            throw new IllegalArgumentException("최소 " + MIN_COUNT_OF_PERSON + "명 이상의 참가자가 있어야 합니다.");
        }
        this.values = values;
    }

    public List<Name> values() {
        return new ArrayList<>(values);
    }

    public int positionOfPlayer(Name nameOfPlayer) {
        return values.indexOf(nameOfPlayer);
    }

    public int size() {
        return values.size();
    }
}
