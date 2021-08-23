package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @Test
    public void 사다리를_생성할_수_있다() {
        //given

        //when
        Ladder ladder = Ladder.createWithHeight(6);
        //then
        assertThat(ladder).isEqualTo(Ladder.createWithHeight(6));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void 사다리는_높이가_1보다_작으면_익셉션이_발생한다(int input){
        //given
        //when
        //then
        assertThatThrownBy(() -> Ladder.createWithHeight(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이는 1 이상이어야 합니다.");
    }
}
