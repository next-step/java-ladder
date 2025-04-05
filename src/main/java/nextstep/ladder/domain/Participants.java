package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {
    public static final String TOO_FEW_PARTICIPANTS_MESSAGE = "참여자는 2명 이상이어야 합니다.";
    private final List<Participant> names;

    public Participants(String[] names) {
        this(List.of(names));
    }

    public Participants(List<String> names) {
        this.valid(names);
        this.names = names.stream().map(Participant::new).collect(Collectors.toUnmodifiableList());
    }

    private void valid(List<String> names) {
        if (names == null || names.size() < 2) {
            throw new IllegalArgumentException(TOO_FEW_PARTICIPANTS_MESSAGE);
        }
    }

    public List<Participant> getNames() {
        return this.names;
    }

    public int size() {
        return this.names.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(names);
    }
}
