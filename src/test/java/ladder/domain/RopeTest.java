package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("next Test")
    @Test
    public void nextTest() {
        assertThat(Rope.present().next())
                .isEqualTo(Rope.empty());

        assertThat(
                Stream.iterate(Rope.empty(), Rope::next)
                        .limit(1000)
                        .anyMatch(iRope -> iRope.equals(Rope.present()))
        ).isTrue();
    }
}