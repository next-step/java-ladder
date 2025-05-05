package nextstep.ladder.domain.name;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NamesTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void 공백문자열은_입력될수없다(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Names(input);
        });
    }

    @Test
    public void 빈리스트는_입력될수없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Names(new ArrayList<>());
        });
    }

    @Test
    public void 이름을통해_position값을_구할수있다() {
        String input = "aaa, bbb, ccc";
        Names names = new Names(input);

        assertThat(names.positionOf(new Name("bbb"))).isEqualTo(1);
    }
}