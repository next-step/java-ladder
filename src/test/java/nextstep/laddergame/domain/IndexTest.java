package nextstep.laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexTest {

    @Test
    void create() {
        Index index = Index.from(1);
        Assertions.assertThat(index).isNotNull();
    }
}