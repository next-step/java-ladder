package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    @Test
    @DisplayName("참가자 리스트 생성 기능")
    void initUsers() {
        String names = "java,study,game";
        Users users = setUp(names);

        assertThat(users.getUsers().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("초기 user와 인덱스 맵 생성")
    void mapUserIndex() {
        String names = "java,study,game";
        Users users = setUp(names);

        Map<User, Integer> userMap = users.mapUserIndex();

        Map<User, Integer> newUser = new HashMap<>();
        newUser.put(User.from("java"), 0);
        newUser.put(User.from("study"), 1);
        newUser.put(User.from("game"), 2);

        Assertions.assertThat(userMap).isEqualTo(newUser);
    }

    private Users setUp(String names) {
        InputUsers inputUsers = InputUsers.createInputUsers(names);
        return Users.createUsers(inputUsers);
    }

}