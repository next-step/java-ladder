package nextstep.ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinProductsTest {

    @DisplayName("당첨 상품을 반환한다.")
    @Test
    void getWinProductOf() {
        // given
        WinProducts winProducts = WinProducts.from(List.of("poppy", "jetty"));

        // then
        Assertions.assertAll(
                () -> assertThat(winProducts.getWinProductOf(0)).isEqualTo("poppy"),
                () -> assertThat(winProducts.getWinProductOf(1)).isEqualTo("jetty")
        );
    }
}
