package nextstep.ladder.participant;

import nextstep.ladder.domain.participant.Participants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {
    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        assertThat(new Participants("1,2,3,4,5"))
                .isInstanceOf(Participants.class)
                .extracting("participants")
                .asList()
                .hasSize(5);
    }

    @Test
    @DisplayName("참여자들의 이름이 빈값일 경우 exception")
    void nullOrBlank() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new Participants(null))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Participants(""))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Participants(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("참여자들의 이름 출력 테스트")
    void nameList() {
        assertThat(new Participants("1,2,3,4,5").getNames())
                .hasSize(5)
                .containsExactly("1","2","3","4","5");
    }
}
