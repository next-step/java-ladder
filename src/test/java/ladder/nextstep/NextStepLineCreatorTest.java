package ladder.nextstep;

import ladder.engine.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NextStepLineCreatorTest {
    private NextStepLineCreator lineRepository;

    @BeforeEach
    void setUp() {
        lineRepository = new NextStepLineCreator();
    }

    @Test
    void create() {
        Line line = lineRepository.create(3);
        System.out.println(line);
    }
}
