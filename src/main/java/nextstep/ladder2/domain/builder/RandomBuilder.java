package nextstep.ladder2.domain.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import nextstep.ladder2.domain.NxLine;

public class RandomBuilder implements LadderBuilder {
    public static final Random random = new Random();

    @Override
    public List<NxLine> build(int height, int countOfPerson) {
        List<NxLine> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(createLine(countOfPerson));
        }
        return lines;
    }

    private NxLine createLine(int countOfPerson) {
        List<Boolean> booleans = new ArrayList<>();
        boolean prev = false;
        for(int i = 0; i < countOfPerson - 1; i++) {
            prev = nextBoolean(prev);
            booleans.add(prev);
        }
        return new NxLine(booleans);
    }

    private boolean nextBoolean(boolean prev) {
        boolean next;
        do {
            next = random.nextBoolean();
        } while (prev && next);
        return next;
    }
}
