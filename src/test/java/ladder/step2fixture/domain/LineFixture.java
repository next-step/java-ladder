package ladder.step2fixture.domain;

import ladder.step2.domain.Line;

import java.util.Arrays;

public class LineFixture {
    public static final Line LINE = new Line(Arrays.asList(PartLineFixture.FALSE, PartLineFixture.TRUE, PartLineFixture.FALSE, PartLineFixture.TRUE, PartLineFixture.FALSE));
}
