package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

class RandomLineGeneratorTest {

    @Test
    void generate() {
        LineGenerator lineGenerator = new RandomLineGenerator();
        Line line = lineGenerator.generate(5);
        System.out.println(line);
    }

    @Test
    void generate_SinglePoint() {
        LineGenerator lineGenerator = new RandomLineGenerator();
        Line line = lineGenerator.generate(1);
        System.out.println(line);
    }
}
