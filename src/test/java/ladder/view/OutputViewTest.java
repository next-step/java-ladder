package ladder.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {


    @Test
    void printLadderTest() {
        OutputView outputView = new OutputView();
        outputView.printLadder(null);
    }

}