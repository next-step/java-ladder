package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RopeTest {
    @DisplayName("동일성 테스트")
    @Test
    public void sameTest() {
        assertThat(Rope.present())
                .isEqualTo(Rope.present());

        assertThat(Rope.present())
                .isSameAs(Rope.present());

        assertThat(Rope.empty())
                .isEqualTo(Rope.empty());

        assertThat(Rope.empty())
                .isSameAs(Rope.empty());
    }
}