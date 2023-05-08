package nextstep.ladder.domain.participant;

import java.util.Objects;
import java.util.Optional;

public class Participant {
    private final Name name;

    public Participant(Name name) {
        this.name = Optional.ofNullable(name)
                .orElseThrow(() -> new IllegalArgumentException("이름은 빈 칸일 수 없습니다."));
    }

    String getName() {
        return this.name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
