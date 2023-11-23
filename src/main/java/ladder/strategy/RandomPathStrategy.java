package ladder.strategy;

import java.util.List;
import java.util.Random;

public class RandomPathStrategy implements PathStrategy {

    private static final Random random = new Random();

    @Override
    public void initialize(List<Boolean> paths) {
        for (int index = 0; index < paths.size(); index++) {

            if (editablePath(paths, index)) {
                paths.set(index, random());
                continue;
            }

            paths.set(index, Boolean.FALSE);
        }
    }

    private boolean editablePath(List<Boolean> paths, int index) {
        return firstPath(index) || previousPathNotMovable(paths, index);
    }

    private boolean firstPath(int index) {
        return index == 0;
    }

    private boolean previousPathNotMovable(List<Boolean> paths, int index) {
        return previousPath(paths, index).equals(Boolean.FALSE);
    }

    private Boolean previousPath(List<Boolean> paths, int index) {
        return paths.get(index - 1);
    }

    private Boolean random() {
        return random.nextBoolean();
    }
}
