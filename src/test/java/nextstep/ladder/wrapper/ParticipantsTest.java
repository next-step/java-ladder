package nextstep.ladder.wrapper;

import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.User;
import nextstep.ladder.wrapper.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ParticipantsTest {

    @DisplayName("참여자 생성 테스트")
    @Test
    void create_참여자() {
        // given
        Participants participants = Participants.valueOf("user1", "user2", "user3");
        // when
        Participants expected = Participants.valueOf("user1", "user2", "user3");
        // then
        assertThat(participants).isEqualTo(expected);
    }

    @DisplayName("참여자 위치정보 확인 테스트")
    @Test
    void create_참여자_위치정보확인() {
        // given
        Participants participants = Participants.valueOf("user1", "user2");
        // when
        Set<User> users = participants.getUsers();
        Iterator<User> iterator = users.iterator();
        // then
        assertAll(
                () -> assertThat(iterator.next().position()).isEqualTo(Position.valueOf(0)),
                () -> assertThat(iterator.next().position()).isEqualTo(Position.valueOf(1))
        );
    }
}
