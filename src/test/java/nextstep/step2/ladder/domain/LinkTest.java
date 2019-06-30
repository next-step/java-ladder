package nextstep.step2.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-30 03:09
 */
public class LinkTest {

    @DisplayName("Link의 상태를 가지고 온다")
    @Test
    void status() {
        Link link = Link.of(true);
        assertThat(link.status()).isTrue();
    }

}
