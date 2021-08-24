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

    @Test
    public void 위치를_입력받아서_체크할_수_있다(){
        //given
        Width width = Width.create(6);
        Line line = Line.createWithWidth(width);
        //when
        line.check(3);
        //then
        assertThat(line).isEqualTo(Line.create(false, false, false, true, false, false));
    }
}
