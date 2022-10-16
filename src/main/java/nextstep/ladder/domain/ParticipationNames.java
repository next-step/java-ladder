package nextstep.ladder.domain;

import java.util.List;

public class ParticipationNames {

    private final List<String> names;

    public ParticipationNames(final List<String> names) {

        validate(names);
        this.names = names;
    }

    private void validate(final List<String> names) {

        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("참가자 이름은 필수값입니다.");
        }
    }

    public List<String> getName() {

        return names;
    }

    public int size() {

        return this.names.size();
    }
}
