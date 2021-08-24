package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    public void 높이와_너비를_받아서_Lines를_만들_수_있다(){
        //given
        Width width = Width.create(3);
        Height height = Height.create(3);
        //when
        Lines lines = Lines.create(width, height);
        //then
        assertThat(lines).isEqualTo(Lines.create(Width.create(3), Height.create(3)));
    }
}