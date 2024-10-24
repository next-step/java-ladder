package laddergame.v1.domain;

import java.util.List;

public interface LadderLineGenerator {
    List<Boolean> generate(int size);
}
