package nextstep.step2.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-29 02:11
 */
public class CustomTest {

    @DisplayName("사용자들 이름을 전달받아 Custom 객체 생성하여 이름 리스트 받아오기")
    @Test
    void createCustoms() {
        List<Name> customName = Arrays.asList(
                Name.of("kwon"),
                Name.of("byeon"),
                Name.of("yun"));

        Custom custom = new Custom(customName);
        Name kwon = new Name("kwon");

        assertThat(custom.hasCustom(kwon)).isTrue();
    }

    @DisplayName("입력된 사용자의 count 가지고 오기")
    @Test
    void countCustoms() {
        List<Name> customName = Arrays.asList(
                Name.of("kwon"),
                Name.of("byeon"),
                Name.of("yun"));

        Custom custom = new Custom(customName);
        assertThat(custom.count()).isEqualTo(3);
    }
}
