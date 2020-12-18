package nextstep.laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GiftTest {

    @Test
    void create() {
        Assertions.assertThat(Gift.from("aaaa")).isNotNull();
    }
}