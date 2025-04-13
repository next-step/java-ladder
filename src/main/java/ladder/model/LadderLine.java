package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {
    private final List<Boolean> crosses;

    private LadderLine(List<Boolean> crosses) {
       this.crosses = crosses;
    }

    public static LadderLine genRandomLadderLine(int width, Random random) {
        List<Boolean> exist = new ArrayList<>();

        for (int i = 0; i < width - 1; i++) {
            if (i > 0 && exist.get(i - 1)) {
                exist.add(false);
            } else {
                exist.add(random.nextBoolean());
            }
        }

        return new LadderLine(exist);
    }

    public List<Boolean> crosses(){
        return crosses;
    }

    public int size() {
        return crosses.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LadderLine ll = (LadderLine) o;
        return crosses.equals(ll.crosses);
    }

    @Override
    public int hashCode() {
        return crosses.hashCode();
    }

}
