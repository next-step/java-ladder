package nextstep.ladder.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class UserConverterTest {

    @Test
    @DisplayName("String[] 을 String으로 변환 테스트")
    void convertToListString() {
        String[] userArray = new String[]{"terry", "khan", "mat"};
        String users = UserConverter.convertToString(userArray);
        assertThat(users).isEqualTo("terry,khan,mat");

    }
}
