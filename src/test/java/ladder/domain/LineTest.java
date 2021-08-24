package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 너비를_받아서_Line을_만들_수_있다(){
        //given
        Width width = Width.create(6);
        //when
        Line line = Line.createWithWidth(width);
        //then
        assertThat(line).isEqualTo(Line.createWithWidth(Width.create(6)));
    }
}
