package nextstep.ladder.domain;

import java.util.List;

public interface GenerableStrategy {
    List<Boolean> generate(int length);
}
