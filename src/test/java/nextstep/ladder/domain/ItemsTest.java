package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemsTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void creat() {
        String itemsText = "꽝,1000,꽝,꽝";
        Items items = Items.from(itemsText);

        assertThat(items).isNotNull();
    }
}
