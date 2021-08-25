package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    @Test
    public void List를_받아서_Line_을_생성할_수_있다(){
        //given
        //when
        Line line = Line.create(Arrays.asList(true, false, false, true));
        //then
        assertThat(line).isEqualTo(Line.create(true, false, false, true));
    }

}
