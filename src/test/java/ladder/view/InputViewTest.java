package ladder.view;

import ladder.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {
    @DisplayName("유저 이름 입력 테스트")
    @Test
    public void getUsersTest() {
        String testInput = "pobi,honux,crong,jk";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        List<User> users = InputView.getUsers();

        assertEquals(4, users.size());
        assertEquals("pobi", users.get(0).getName());
        assertEquals("honux", users.get(1).getName());
        assertEquals("crong", users.get(2).getName());
        assertEquals("jk", users.get(3).getName());

        System.setIn(System.in);
    }
}
