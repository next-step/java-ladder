package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GoodsTest {
    @Test
    void create() {
        Goods goods = Goods.of("꽝,5000,2000,꽝");
        assertThat(goods).isEqualTo(Goods.of("꽝,5000,2000,꽝"));
    }
}