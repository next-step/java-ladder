package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void generateLineTest(){
        int countOfName = 3;
        Boolean initPoint = false;
        Line line = new Line(countOfName);

        List<Boolean> generatedlines = line.generateLine(initPoint);

        assertThat(generatedlines).hasSize(2);
    }

}