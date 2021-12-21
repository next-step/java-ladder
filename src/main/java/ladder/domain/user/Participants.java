package ladder.domain.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participants {

    private static final int MINIMUM_NUMBER_OF_PARTICIPANTS = 2;
    private static final String DELIMITER = ",";

    private final List<Name> names = new ArrayList<>();

    public Participants(String names) {
        validate(names);
        String[] split = names.split(DELIMITER);
        for (String name : split) {
            this.names.add(new Name(name));
        }
    }

    private void validate(String names) {
        if (names.split(DELIMITER).length < MINIMUM_NUMBER_OF_PARTICIPANTS) {
            throw new IllegalArgumentException("참가자가 2명 이상이어야 게임을 진행할 수 있습니다.");
        }
    }

    public List<Name> get() {
        return Collections.unmodifiableList(names);
    }

    public Name getName(int index) {
        return names.get(index);
    }

    public int size() {
        return names.size();
    }
}
