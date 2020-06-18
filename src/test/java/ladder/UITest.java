package ladder;

import ladder.domain.Draw;
import ladder.domain.UI;
import org.junit.jupiter.api.Test;

public class UITest {
    @Test
    void displayUI() {
        System.out.println(UI.find(new Draw(true)).getString() +
                UI.find().getString() +
                UI.find(new Draw(false)).getString());
    }
}
