package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.user.Name;
import step02.user.Users;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {

    @Test
    @DisplayName("쉼표 구분으로 각 Name 객체 생성 테스트")
    void splitNameTest() {
        List<Name> names = Users.splitName("user1,user2,user3");
        assertThat(names).contains(new Name("user1")).contains(new Name("user2")).contains(new Name("user3"));
    }
}
