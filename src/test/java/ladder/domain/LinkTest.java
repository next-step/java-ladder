package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkTest {

    @Test
    void 생성() {
        Link link = new Link(true);
        assertThat(link).isEqualTo(new Link(true));
    }
}
