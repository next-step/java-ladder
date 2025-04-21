package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import nextstep.ladder.domain.Participant;
import org.junit.jupiter.api.Test;

public class ParticipantTest {

  @Test
  public void 참여자_이름_글자수_5글자까지_제한(){
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new Participant("crong2"));
  }
}
