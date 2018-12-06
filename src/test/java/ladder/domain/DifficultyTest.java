package ladder.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class DifficultyTest {

    @Test
    public void findByText() {
        Difficulty difficulty = Difficulty.findByText("상");
        System.out.println(difficulty);


    }

    @Test
    public void findByHeight() {
    }
}
