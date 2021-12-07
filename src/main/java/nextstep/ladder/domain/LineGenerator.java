package nextstep.ladder.domain;

import java.util.List;

public interface LineGenerator {
    Line generate(List<Boolean> row);

    void validateRow(List<Boolean> row);
}
