package nextstep.ladder.utils;

import nextstep.ladder.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserConverterTest {

    @Test
    @DisplayName("String[] 을 List<User> 변환 테스트")
    void convertToListString() {
        String[] userArray = new String[]{"terry", "khan", "mat"};
        List<User> users = UserConverter.convertToList(userArray);
        assertThat(users).hasSize(userArray.length);

    }
}
