package nextstep.laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IndexTest {

    @Test
    void create() {
        Index index = Index.from(1);
        assertThat(index).isNotNull();
    }
}