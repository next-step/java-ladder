package nextstep.ladder.domain;

import java.util.Random;

public abstract class LineExistsGenerator {

    protected static final Random RANDOM = new Random();

    public abstract boolean generate(boolean prev);
}
