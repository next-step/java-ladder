package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Rewords {

    private final List<Reword> rewords;

    private Rewords(List<Reword> rewords) {
        this.rewords = rewords;
    }

    public static Rewords newInstance(List<Reword> rewords, int countOfPlayer) {
        validate(rewords, countOfPlayer);
        return new Rewords(rewords);
    }

    private static void validate(List<Reword> rewords, int countOfPlayer) {
        if (rewords == null) {
            throw new IllegalArgumentException("실행 결과들이 존재하지 않습니다.");
        }

        if (rewords.size() != countOfPlayer) {
            throw new IllegalArgumentException("참여자 수와 실행 결과 수가 일치하지 않습니다.");
        }

        if (rewords.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("존재하지 않는 실행 결과가 포함되어 있습니다.");
        }
    }

    public List<Reword> toList() {
        return Collections.unmodifiableList(this.rewords);
    }

    public Reword findByPosition(Position position) {
        return this.rewords.get(position.value());
    }
}
