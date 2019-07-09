package nextstep.step4.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
        }).withMessageContaining("사용자의 이름이 유효하지 않습니다. (1~5글자만 입력가능)");
    }

    @DisplayName("사용자의 이름이 전달받은 Name 객체와 같은지 확인")
    @Test
    void matchName() {
        Name sourceName = Name.of("kwon");
        assertThat(sourceName.matchName("kwon")).isTrue();
    }

    @DisplayName("사용자의 이름을 반환 받는다.")
    @Test
    void getName() {
        Name name = Name.of("kwon");
        assertThat(name.getName()).isEqualTo("kwon");
    }
}
