package ladder.view.input;

import ladder.common.Csv;
import ladder.common.PositiveNumber;

public interface InputView {
    Csv getUserNames();
    PositiveNumber getLadderHeight();
}
