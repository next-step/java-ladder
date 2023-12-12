package nextstep.ladder.fixtures;

import nextstep.ladder.domain.Brace;

public class BraceFixtures {
    public static Brace none() {
        return new Brace(false, false);
    }
    public static Brace left() {
        return new Brace(true, false);
    }
    public static Brace right() {
        return new Brace(false, true);
    }
}
