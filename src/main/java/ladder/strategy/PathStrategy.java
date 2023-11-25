package ladder.strategy;

import java.util.List;

public interface PathStrategy {
    List<Boolean> generate(long size);
}
