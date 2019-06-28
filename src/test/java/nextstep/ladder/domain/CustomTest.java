package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @ParameterizedTest
    @ValueSource(strings = {"kwon","byeon", "yun"})
    void createCustoms(String names) {
        List<String> customName = Arrays.asList("kwon", "byeon", "yun");
        Custom custom = new Custom(customName);
        assertThat(custom.hasCustom(names)).isTrue();
    }
}
