package ladderGame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Layer {
    private List<Boolean> rungs;

    private Layer(List<Boolean> rungs) {
        this.rungs = rungs;
    }

    public static Layer fromEntry(int entry) {
        List<Boolean> list = new ArrayList<>();
        Boolean previous = false;
        for (int i = 0; i < entry; i++) {
            previous = test(previous);
            list.add(previous);
        }
        return new Layer(list);
    }

    private static Boolean test(boolean key) {
        if (!key) {
            return getRandom();
        }
        return false;
    }

    public static Layer fromEntry(List<Boolean> rungs) {
        rungs.stream()
                .map(Rung::new)
                .collect(Collectors.toList());
        return new Layer(rungs);
    }

    private static boolean getRandom() {
        return new Random().nextBoolean();
    }

    public List<Boolean> getRungs() {
        return rungs;
    }
}
