package ladder.domain.fake;

import ladder.domain.generator.LineGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeTwoByOneLineGenerator implements LineGenerator {

    @Override
    public List<Boolean> generate(final int playerCount) {
        return new ArrayList<>(Arrays.asList(false, true));
    }
}
