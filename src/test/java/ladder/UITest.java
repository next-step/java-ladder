package ladder;

import ladder.domain.UI;
import ladder.view.ResultView;
import org.junit.jupiter.api.Test;

public class UITest {
    @Test
    void displayUI() {
        System.out.println(UI.find(ResultView.LADDER_HORIZONTAL).getString() +
                UI.find(ResultView.LADDER_EMPTY).getString() +
                UI.find(ResultView.LADDER_VERTICAL).getString());
    }
}
