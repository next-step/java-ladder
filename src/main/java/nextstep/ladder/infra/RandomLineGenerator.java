package nextstep.ladder.infra;

import nextstep.ladder.domain.LineGenerator;
import nextstep.ladder.domain.LineLength;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomLineGenerator implements LineGenerator {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public List<Boolean> generate(LineLength length) {
        List<Boolean> line = new ArrayList<>();
        Boolean prev = false;

        for (int i = 0; i < length.getLength(); i++) {
            Boolean cur = random.nextBoolean();
            cur = toNonOverlapBridge(prev, cur);

            line.add(cur);
            prev = cur;
        }

        return line;
    }

    private Boolean toNonOverlapBridge(boolean prev, boolean cur) {
        if (cur && prev) {
            return Boolean.FALSE;
        }

        return cur;
    }
}
