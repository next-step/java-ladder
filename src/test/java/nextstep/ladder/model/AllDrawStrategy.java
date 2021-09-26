package nextstep.ladder.model;

import nextstep.ladder.model.v1.DrawStrategy;

public class AllDrawStrategy implements DrawStrategy {
    @Override
    public boolean draw() {
        return true;
    }
}
