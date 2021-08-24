package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @Test
    public void 세로길이_객체를_생성할_수_있다(){
        //given
        //when
        Height height = Height.create(3);
        //then
        assertThat(height).isEqualTo(Height.create(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void 세로길이가_1보다_작으면_익셉션이_발생한다(int length){
        //given
        //when
        //then
        assertThatThrownBy(() -> Height.create(length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 세로길이는 1 이상이어야 합니다.");
    }

}