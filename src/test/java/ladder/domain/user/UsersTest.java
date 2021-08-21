package ladder.domain.user;

import ladder.exception.OverlapUserNamesException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Users Test")
public class UsersTest {

    @Test
    @DisplayName("중복된 유저이름이 있을경우 Exception 발생")
    void overlapUserNameException() {
        List<String> userNames = Arrays.asList("tom", "tom");
        assertThatThrownBy(() -> new Users(userNames))
                .isInstanceOf(OverlapUserNamesException.class);
    }
}
