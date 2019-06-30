package nextstep.step2.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-29 02:21
 */
public class NameTest {

    @DisplayName("생성하기 전에 고객의 이름이 5글자가 안넘는지 체크 - Exception")
    @Test
    void createName() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Name name = Name.of("byeong");
        }).withMessageContaining("사용자 이름은 5글자 이하만 가능합니다.");
    }
}
