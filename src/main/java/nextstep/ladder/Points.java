package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Points {
    private final List<Boolean> values;
    private final Random random = new Random();

    public Points(CountOfPerson countOfPerson) {
        this.values = new ArrayList<>(countOfPerson.value - 1);
        setPoints(countOfPerson);
    }

    private void setPoints(CountOfPerson countOfPerson) {
        values.add(random.nextBoolean());
        for (int j = 1; j < countOfPerson.value - 1; j++) {
            if (values.get(j - 1)) {
                values.add(false);
                continue;
            }
            values.add(random.nextBoolean());
        }
    }

    public int size() {
        return values.size();
    }
}
