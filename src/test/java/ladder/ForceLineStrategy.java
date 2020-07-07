package ladder;

import ladder.domain.HorizontalLineStrategy;

public class ForceLineStrategy implements HorizontalLineStrategy {
    @Override
    public boolean isDrawLine() {
        return true;
    }
}
