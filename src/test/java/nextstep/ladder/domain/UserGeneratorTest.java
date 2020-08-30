package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserGeneratorTest {

    private String names;

    @BeforeEach
    void setUp() {
        names = "pobi,honux,crong,jk";
    }

    @Test
    @DisplayName("참여하는 유저 split")
    void userSplit() {
        String[] users = UserGenerator.getUserName(names);
        assertThat(users).contains("pobi", "honux", "crong", "jk");
    }

    @Test
    @DisplayName("유저 List Size")
    void userListSize() {
        List<User> users = UserGenerator.generateUsers(names);
        assertThat(users).hasSize(4);
    }

}
