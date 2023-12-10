package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LinesGeneratorTest {

    private final LinesGenerator linesGenerator = new LinesGenerator();

    @Test
    public void generatorLines_높이에_맞게_생성하는지_테스트() {
        assertThat(linesGenerator.generatorLines(5, 6)).hasSize(6);
    }

    @Test
    public void generatorLines_높이가_0일때_에러_테스트() {
        assertThatThrownBy( () -> linesGenerator.generatorLines(5, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
