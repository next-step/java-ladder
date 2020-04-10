package ladder.domain.fake;

import ladder.domain.Stair;
import ladder.domain.generator.LineGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeTwoByZeroLineGenerator implements LineGenerator {

    @Override
    public List<Stair> generate(final int playerCount) {
        return new ArrayList<>(Arrays.asList(new Stair().first(), new Stair(false)));
    }
}
