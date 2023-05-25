package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoLineStrategy implements LineStrategy {
    @Override
    public List<Boolean> generate(int n) {
        return new ArrayList<>(Collections.nCopies(n, false));
    }
}
