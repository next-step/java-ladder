package ladder.domain;

import ladder.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class LadderTest {
    private List<Name> names = new ArrayList<>();
    @BeforeEach
    void setUp() {
        names.add(new Name("harr"));
        names.add(new Name("horr"));
        names.add(new Name("hurr"));
        names.add(new Name("hirr"));
        names.add(new Name("herr"));
    }

    @Test
    @DisplayName("사다리 생성 View 확인")
    void constructor(){
        Random random = new Random();
        Ladder ladder = new Ladder(5, 5, () -> random.nextBoolean());
        ResultView resultView = new ResultView();
        resultView.printLadder(names, ladder);
    }
}