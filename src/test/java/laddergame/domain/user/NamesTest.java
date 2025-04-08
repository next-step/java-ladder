package laddergame.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {
    @DisplayName("이름들 생성 테스트")
    @Test
    void create_names() {
        assertThat(new Names("pobi,honux,crong,jk").size())
                .isEqualTo(4);
    }
}
