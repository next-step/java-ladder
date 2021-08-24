package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WidthTest {

    @Test
    public void 가로길이_객체를_생성할_수_있다(){
        //given
        //when
        Width width = Width.create(3);
        //then
        assertThat(width).isEqualTo(Width.create(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -1})
    public void 가로길이가_2보다_작으면_익셉션이_발생한다(int length){
        //given
        //when
        //then
        assertThatThrownBy(() -> Width.create(length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 가로길이는 2 이상이어야 합니다.");
    }

}