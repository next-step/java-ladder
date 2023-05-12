package nextstep.domain;

import java.util.List;

public interface LineCreateStrategy {

    List<Boolean> create(int peopleCount);
}
