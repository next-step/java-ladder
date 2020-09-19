package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("유저 리스트 생성")
    void create() {
        UserList userList = UserList.create("pobi,honux,crong,jk");
        assertEquals(userList.getTotalParticipantsCount(), 4);
    }
}

