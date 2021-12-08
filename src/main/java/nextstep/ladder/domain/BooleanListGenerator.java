package nextstep.ladder.domain;

import java.util.List;

public interface BooleanListGenerator {
    List<Boolean> generate();

    void validateListCount(int count);
}
