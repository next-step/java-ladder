package nextstep.ladder.controller;

import nextstep.ladder.domain.InputUsers;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderControllerTest {

    LadderController controller;

    @Test
    @DisplayName("참가자 리스트 생성 기능")
    void initUsers() {
        String names = "java,study,game";
        InputUsers inputUsers = new InputUsers(names);
        controller = new LadderController();

        List<User> userList = new ArrayList<>();
        for(String name : names.split(",")) {
            userList.add(new User(name));
        }

        Users users = controller.initUsers(inputUsers);
        assertThat(users).isEqualTo(new Users(userList));
    }

}