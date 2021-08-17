package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

class RandomLadderGeneratorTest {

    @Test
    void generate() {
        LadderGenerator ladderGenerator = new RandomLadderGenerator(new RandomLineGenerator());
        Ladder ladder = ladderGenerator.generate(3, 4);
        System.out.println(ladder);
    }
}
