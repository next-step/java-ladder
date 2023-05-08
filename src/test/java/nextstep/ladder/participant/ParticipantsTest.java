package nextstep.ladder.participant;

import nextstep.ladder.domain.participant.Name;
import nextstep.ladder.domain.participant.Participant;
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
    @DisplayName("이름중 all 이 들어가면 무시하고 생성")
    void createALl() {
        assertThat(new Participants("1,2,3,4,all"))
                .isInstanceOf(Participants.class)
                .extracting("participants")
                .asList()
                .hasSize(4);
    }

    @Test
    @DisplayName("참여자 이름이 중복될 경우 생략하고 객체생성")
    void createSameName() {
        assertThat(new Participants("1,2,3,4,4"))
                .isInstanceOf(Participants.class)
                .extracting("participants")
                .asList()
                .containsExactly(new Participant(new Name("1")), new Participant(new Name("2")), new Participant(new Name("3")), new Participant(new Name("4")))
                .hasSize(4);
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
                .containsExactly("1", "2", "3", "4", "5");
    }

    @Test
    @DisplayName("참여자 이름으로 인덱스 확인")
    void indexByName() {
        final Participants participants = new Participants("1,2,3");

        Assertions.assertAll(
                () -> assertThat(participants.indexByName("1"))
                        .isEqualTo(0),
                () -> assertThat(participants.indexByName("2"))
                        .isEqualTo(1),
                () -> assertThat(participants.indexByName("3"))
                        .isEqualTo(2),
                () -> assertThatThrownBy(() -> participants.indexByName("4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
