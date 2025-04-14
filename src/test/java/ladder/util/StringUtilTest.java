package ladder.util;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @Test
    @DisplayName("parseUserList 메서드가 정상적으로 동작하는지 확인")
    void testParseValid() {
        String userList = "John,Alice,Bob";

        List<String> users = StringUtil.parse(userList);
        assertThat(users).containsExactly("John", "Alice", "Bob");
    }

    @Test
    @DisplayName("parseUserList 메서드가 빈 문자열을 입력받았을 때, 빈 리스트를 반환하는지 확인")
    void testParseEmpty() {
        String userList = "";

        List<String> users = StringUtil.parse(userList);
        assertThat(users).containsExactly("");
    }

    @Test
    @DisplayName("하나의 이름만 있는 경우 정상적으로 동작하는지 확인")
    void testParseUserListSingleUser() {
        String userList = "Charlie";

        List<String> users = StringUtil.parse(userList);
        assertThat(users).containsExactly("Charlie");
    }
}
