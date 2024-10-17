package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixedLineGenerator implements LineGenerator {

    private List<Boolean> points;

    @Override
    public List<Boolean> run(int ladderSize) {
        points = new ArrayList<>();
        for (int i = 0; i < ladderSize; i++) {
            points.add(false);
        }
        return points;
    }

    public List<Boolean> run(Boolean... booleans) {
        points = Arrays.stream(booleans).collect(Collectors.toList());
        return points;
    }
}
