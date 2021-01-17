package ladder.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setup(){
    }

    @Test
    void ladderNames(){
        String names = "morr,dani";
        int height= 5;
        new Ladder(names,height);
    }

}