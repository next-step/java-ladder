package ladder.step2fixture.domain;

import ladder.step2.domain.Ladder;

import java.util.Arrays;

public class LadderFixture {
    public static final Ladder LADDER = new Ladder(Arrays.asList(LineFixture.LINE, LineFixture.LINE, LineFixture.LINE, LineFixture.LINE, LineFixture.LINE));
}
