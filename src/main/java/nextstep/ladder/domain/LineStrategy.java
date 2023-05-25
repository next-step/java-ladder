package nextstep.ladder.domain;

import java.util.List;

public interface LineStrategy {
    List<Boolean> generate(int n);
}
