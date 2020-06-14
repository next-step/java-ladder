package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameUsersTest {

    @DisplayName("중복된 유저네임을 입력하면 Exception을 던진다")
    @Test
    void duplicate() {
        //given
        String user1 = "abc";
        String user2 = "abc";

        //when
        //then
        assertThatThrownBy(() -> new LadderGameUsers(createLadderGameUsers()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("LadderGameUser는 중복된 이름을 가질 수 없습니다.");

    }

    private List<LadderGameUser> createLadderGameUsers() {
        LadderGameUser user1 = new LadderGameUser(Order.FIRST_ORDER, "abc");
        LadderGameUser user2 = new LadderGameUser(Order.of(2), "abc");
        return Arrays.asList(user1, user2);
    }
}