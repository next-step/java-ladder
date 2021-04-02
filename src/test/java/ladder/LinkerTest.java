package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkerTest {
    @ParameterizedTest
    @DisplayName("LinkSelector에 따라 링크를 잘 만드는지 테스트")
    @MethodSource("provideLinkSelectorAndExpected")
    void Given_LinkSelector_When_Link_Then_ExpectedLink(LinkSelector linkSelector, Link expected) {
        Linker linker = new Linker(linkSelector);
        assertThat(linker.link()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLinkSelectorAndExpected() {
        return Stream.of(
                Arguments.of((LinkSelector) () -> Link.CLOSE, Link.CLOSE),
                Arguments.of((LinkSelector) () -> Link.OPEN, Link.OPEN),
                Arguments.of(null, Link.OPEN)
        );
    }

    @Test
    @DisplayName("이전 링크가 닫혔으면, 항상 열린 링크를 반환 테스트")
    void Given_ClosedPreviousLink_When_Link_Then_AlwaysOpen() {
        //given
        Link previousLink = Link.CLOSE;
        Linker linker = new Linker(() -> Link.CLOSE);

        //when then
        assertThat(linker.link(previousLink)).isEqualTo(Link.OPEN);
    }

    @Test
    @DisplayName("이전 링크가 열렸으면, LinkSelector를 사용하는지 테스트")
    void Given_OpenedPreviousLink_When_Link_Then_UseLinkSelector() {
        //given
        Link previousLink = Link.OPEN;
        Linker linker = new Linker(() -> Link.CLOSE);

        //when then
        assertThat(linker.link(previousLink)).isEqualTo(Link.CLOSE);
    }
}
