package nextstep.ladder.domain.participant;

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
}
