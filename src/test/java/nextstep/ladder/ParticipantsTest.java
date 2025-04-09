package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {
  @Test
  @DisplayName("참가자 이름은 최대 5글자까지 부여할 수 있다.")
  void name_length_limit() {
    Participants participants = Participants.of(List.of("abcdefghij", "fghijk"));
    assertThat(participants.names()).containsExactly("abcde", "fghij");
  }
  @Test
  @DisplayName("참여자가 2명 이상이면 생성에 성공한다.")
  void createParticipants_success() {
    Participants participants = Participants.of(List.of("pobi", "crong"));
    assertThat(participants.count()).isEqualTo(2);
  }

  @Test
  @DisplayName("참여자가 1명이면 IllegalArgument 예외가 발생한다.")
  void createParticipants_fail_tooFew() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Participants.of(List.of("pobi")))
        .withMessageContaining("참여자는 2명 이상이어야 합니다.");
  }

}
