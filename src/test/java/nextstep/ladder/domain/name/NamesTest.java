package nextstep.ladder.domain.name;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NamesTest {

    @Test
    public void 공백문자열은_입력될수없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Names("");
        });
    }

    @Test
    public void 빈리스트는_입력될수없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Names(new ArrayList<>());
        });
    }
}