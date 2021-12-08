package nextstep.ladder.domain;

import java.util.List;

public interface BooleanListGenerator {
    List<Boolean> generate(int count);

    void validateListCount(int count);
}
