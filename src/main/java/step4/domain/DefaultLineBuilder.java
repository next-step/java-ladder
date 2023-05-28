package step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DefaultLineBuilder implements LineBuilder {
    private static final DefaultLineBuilder defaultLineBuilder = new DefaultLineBuilder();
    private static final Random random = new Random();

    private DefaultLineBuilder() {
    }

    public static DefaultLineBuilder getInstance() {
        return defaultLineBuilder;
    }

    @Override
    public List<Boolean> buildLine(int countOfPerson) {
        List<Boolean> line = new ArrayList<>();
        for (int i = 0; i < countOfPerson; i++) {
            line.add(makeEachPartOfLine(line, i));
        }
        return line;
    }

    private boolean makeEachPartOfLine(List<Boolean> line, int index) {
        if (index != 0 && line.get(index - 1)) {
            return false;
        }
        return random.nextBoolean();
    }
}
