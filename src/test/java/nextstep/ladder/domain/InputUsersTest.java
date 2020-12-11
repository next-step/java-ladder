package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputUsersTest {

    InputUsers inputUsers;

    @Test
    @DisplayName("참여자가 2명이상이 아닐 경우 예외처리")
    void multipleUsers() {
        String names = "java";
        assertThrows(IllegalArgumentException.class,
                () -> InputUsers.createInputUsers(names));
    }

    @Test
    @DisplayName("참여자 목록에서 참여자 분리")
    void splitUsers() {
        String names = "java,study";
        inputUsers = InputUsers.createInputUsers(names);

        String[] splitUsers = inputUsers.splitUsers();

        assertThat(splitUsers).containsExactly("java","study");
    }

}
