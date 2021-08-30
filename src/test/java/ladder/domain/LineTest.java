package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
public class LineTest {

    @Test
    public void 너비를_받아서_Line을_만들_수_있다() {
        //given
        Width width = Width.create(6);
        //when
        Line line = Line.createWithWidth(width);
        //then
        assertThat(line).isEqualTo(Line.createWithWidth(Width.create(6)));
    }

    @Test
    public void List를_받아서_Line_을_생성할_수_있다() {
        //given
        //when
        Line line = Line.create(Arrays.asList(true, false, false, true));
        //then
        assertThat(line).isEqualTo(Line.create(true, false, false, true));
    }

    @Test
    public void Line의_위치를_입력받아서_연결되어있는지_여부를_판단할_수_있다() {
        //given
        //when
        Line line = Line.create(Arrays.asList(true, false, false, true));
        //then
        assertAll(
                () -> assertTrue(line.isConnected(0)),
                () -> assertFalse(line.isConnected(1))
        );
    }

    @Test
    public void Line의_위치가_연결됬는지_파악할_때_범위를_벗어났다면_익셉션이_발생한다() {
        //given
        //when
        Line line = Line.create(Arrays.asList(true, false, false, true));
        //then
        assertThatThrownBy(() -> line.isConnected(4))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("사다리의 너비의 범위를 벗어났습니다.");
    }

}
