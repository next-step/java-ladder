package ladder.nextstep;

import ladder.engine.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NextStepLineRepositoryTest {
    private NextStepLineRepository lineRepository;

    @BeforeEach
    void setUp() {
        lineRepository = new NextStepLineRepository();
    }

    @Test
    void create() {
        Line line = lineRepository.create(3);
        System.out.println(line);
    }
}
