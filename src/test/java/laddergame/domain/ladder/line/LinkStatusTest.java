package laddergame.domain.ladder.line;

import org.junit.jupiter.api.Test;

import static laddergame.domain.ladder.line.LinkStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LinkStatusTest {

    @Test
    void 연결상태인지확인() {
        assertThat(LINK_BEFORE.isLinked()).isTrue();
        assertThat(LINK_NEXT.isLinked()).isTrue();
        assertThat(NOT_LINK.isLinked()).isFalse();
    }

    @Test
    void 이전점이후점이_순서대로연결되었는지() {
        assertThat(LINK_BEFORE.isLinkedWith(LINK_NEXT)).isTrue();
        assertThat(LINK_NEXT.isLinkedWith(LINK_BEFORE)).isFalse();
    }
}
