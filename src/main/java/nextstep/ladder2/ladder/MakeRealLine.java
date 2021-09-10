package nextstep.ladder2.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakeRealLine implements LineMaker {

    @Override
    public List<Boolean> makeLine(int size) {
        Random random = new Random();
        List<Boolean> result = new ArrayList<>();
        result.add(random.nextBoolean());
        for (int i = 0; i < size - 1; i++) {
            if (!result.get(i)) {
                result.add(random.nextBoolean());
                continue;
            }
            result.add(false);
        }

        return result;
    }
}
