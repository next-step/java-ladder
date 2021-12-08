package nextstep.ladder.domain;

import nextstep.ladder.exception.LineRowException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBooleanListGenerator implements BooleanListGenerator {
    private static final Random RANDOM = new Random();
    private static final int MIN_ROW_COUNT = 2;


    private Boolean generateNextValue(Boolean before) {
        boolean next = RANDOM.nextBoolean();
        if (next && before) {
            return Boolean.FALSE;
        }
        return next;
    }

    @Override
    public List<Boolean> generate(int count) {
        validateListCount(count);
        List<Boolean> line = new ArrayList<>();

        addFirst(line);
        addRest(line, count);

        return line;
    }

    private void addFirst(List<Boolean> line) {
        line.add(RANDOM.nextBoolean());
    }

    private void addRest(List<Boolean> line, int count) {
        for (int i = 1; i < count - 1; i++) {
            Boolean before = line.get(i - 1);
            line.add(generateNextValue(before));
        }

    }

    @Override
    public void validateListCount(int count) {
        if (count < MIN_ROW_COUNT) {
            throw new LineRowException(count);
        }
    }
}
