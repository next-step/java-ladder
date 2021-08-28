package ladder.domain.user;

import ladder.exception.LadderLackOfUserException;
import ladder.exception.OverlapUserNamesException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Users Test")
public class UsersTest {

    @Test
    @DisplayName("중복된 유저이름이 있을경우 Exception 발생")
    void overlapUserNameException() {
        List<String> userNames = Arrays.asList("tom", "tom");
        assertThatThrownBy(() -> Users.of(userNames))
                .isInstanceOf(OverlapUserNamesException.class);
    }

    @Test
    @DisplayName("참여할사람 수가 없을때 Exception 발생")
    void ladderGameNoneUserException() {
        assertThatThrownBy(() -> Users.of(Collections.singletonList("unknown")))
                .isInstanceOf(LadderLackOfUserException.class);
    }
}
