package nextstep.ladder.domain;

import java.util.List;

public interface LineGenerator {
    Line generate(List<Boolean> booleanList);

    void validateRow(List<Boolean> row);
}
