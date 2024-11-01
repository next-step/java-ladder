package nextstep.ladder;

import nextstep.ladder.domain.Link;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkTest {
    @Test
    void createNextLink_현재_연결부가_존재하면_다음_연결부는_존재하지_않는다() {
        assertThat(new Link(true).createNextLink()).isEqualTo(new Link(false));
    }

    @Test
    void createNextLink_현재_연결부가_존재하지_않으면_다음_연결부는_존재하거나_존재하지_않는다() {
        Link nextLink = new Link(true).createNextLink();
        assertThat(nextLink).isIn(new Link(true), new Link(false));
    }
}
