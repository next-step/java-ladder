package ladder.domain.ladder;

import ladder.domain.Gamer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LinesTest {
    private Lines lines;

    /**
     *    |-----|     |
     *    |     |-----|
     */
    @BeforeEach
    void setLines(){
        lines = Lines.of(() -> Arrays.asList(
                Line.of(Arrays.asList(Bar.IS_EXIST, Bar.NOT_EXIST)),
                Line.of(Arrays.asList(Bar.NOT_EXIST, Bar.IS_EXIST))
        ));
    }

    @Test
    void getRawMatrixTest() {
        assertThat(lines.getRawMatrix())
            .containsExactly(
                    Arrays.asList(true,false),
                    Arrays.asList(false,true)
            );
    }

    @Test
    void getResultNumberTest(){
        assertThat(lines.getResultNumber(Gamer.of("test",0)))
                .isEqualTo(LadderNumber.of(2));
    }

    @Test
    void getWidthTest(){
        assertThat(lines.width())
                .isEqualTo(2);
    }
}
