package ladder.domain;

import ladder.ui.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    public void setUp(){
        ladder = new Ladder();
        ladder.createLadder(5,4);
    }

    @DisplayName("사다리 결과값 찍어보기")
    @Test
    public void printLadder(){
        System.out.println(ladder);
    }


}