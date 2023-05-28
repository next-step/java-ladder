package nextstep.ladder;

import java.awt.*;
import java.util.List;

public interface LineStrategy {
    Cross drawLine(int index, int size);

    List<Cross> generate(int size);
}
