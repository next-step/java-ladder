package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void crateItem() {
        Item item = new Item("5000");

        assertThat(item).isNotNull();
    }
}
