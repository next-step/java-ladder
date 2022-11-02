package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UsersTest {
    @DisplayName("사용자 이름목록을 받아 사용자들 객체로 리턴한다.")
    @Test
    void from() {
        List<String> names = List.of("pobby", "luna", "rein");
        assertThat(Users.from(names).names()).hasSameElementsAs(names);
    }
}
