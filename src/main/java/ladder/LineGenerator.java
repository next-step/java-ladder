package ladder;

import java.util.List;

@FunctionalInterface
public interface LineGenerator {
    List<Boolean> run(int ladderSize);
}
