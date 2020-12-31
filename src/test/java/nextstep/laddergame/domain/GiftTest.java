package nextstep.laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GiftTest {

    @Test
    void create() {
        Assertions.assertThat(Gift.from("aaaa")).isNotNull();
    }
}