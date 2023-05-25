package nextstep.ladder;

import java.util.List;

public interface LineStrategy {
    boolean drawLine();

    List<Boolean> generate(int size);
}
