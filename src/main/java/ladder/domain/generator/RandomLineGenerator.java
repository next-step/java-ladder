package ladder.domain.generator;

import ladder.domain.Stair;
import ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomLineGenerator implements LineGenerator {

    public RandomLineGenerator() { }

    @Override
    public List<Stair> generate(int playerCount) {
        final List<Stair> stairs = init();
        for (int i = stairs.size(); i < playerCount; i++) {
            Stair prevStair = stairs.get(i - 1);
            stairs.add(drawLine(prevStair));
        }
        return stairs;
    }

    private List<Stair> init() {
        return new ArrayList<>(Arrays.asList(new Stair().first()));
    }

    private Stair drawLine(final Stair prevStair) {
        if (prevStair.isExist()) {
            return new Stair(Boolean.FALSE);
        }
        return new Stair(RandomUtil.nextBoolean());
    }
}
