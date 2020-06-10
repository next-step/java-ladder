package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Rewards {

    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards newInstance(List<Reward> rewards, int countOfPlayer) {
        validate(rewards, countOfPlayer);
        return new Rewards(rewards);
    }

    private static void validate(List<Reward> rewards, int countOfPlayer) {
        if (rewards == null) {
            throw new IllegalArgumentException("실행 결과들이 존재하지 않습니다.");
        }

        if (rewards.size() != countOfPlayer) {
            throw new IllegalArgumentException("참여자 수와 실행 결과 수가 일치하지 않습니다.");
        }

        if (rewards.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("존재하지 않는 실행 결과가 포함되어 있습니다.");
        }
    }

    public List<Reward> toList() {
        return Collections.unmodifiableList(this.rewards);
    }

    public Reward findByPosition(Position position) {
        return this.rewards.get(position.value());
    }
}
