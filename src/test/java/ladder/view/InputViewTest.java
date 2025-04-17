package ladder.view;

import ladder.domain.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {
    @DisplayName("유저 이름 입력 테스트")
    @Test
    public void getUsersTest() {
        String testInput = "pobi,honux,crong,jk";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        Users users = InputView.getUsers();

        assertEquals(4, users.count());
        assertEquals("pobi", users.getUsers().get(0).getName());
        assertEquals("honux", users.getUsers().get(1).getName());
        assertEquals("crong", users.getUsers().get(2).getName());
        assertEquals("jk", users.getUsers().get(3).getName());

        System.setIn(System.in);
    }
}
