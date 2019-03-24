package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class ParticipantsTest {

  @Test
  public void test_participants_names() {

    // Given
    String pobi = "pobi";
    String honux = "honux";

    // When
    Participants participants = new Participants(Arrays.asList(
        new Participant(pobi),
        new Participant(honux)
    ));

    // Then
    assertThat(participants).isNotNull();
    assertThat(participants.names()).isEqualTo(" " + pobi + " " + honux);
  }

  @Test
  public void test_participants_number() {

    // Given
    String pobi = "pobi";
    String honux = "honux";

    // When
    Participants participants = new Participants(Arrays.asList(
        new Participant(pobi),
        new Participant(honux)
    ));

    // Then
    assertThat(participants).isNotNull();
    assertThat(participants.number()).isEqualTo(2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_participantsIsNull_exception() {

    // When
    new Participants(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_ladder_participantsIsEmpty_exception() {

    // Given
    List<Participant> participants = new ArrayList<>();

    // When
    new Participants(participants);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_ladder_participantsIsSingle_exception() {

    // Given
    String pobi = "pobi";

    List<Participant> participants = Collections.singletonList(
        new Participant(pobi)
    );

    // When
    new Participants(participants);
  }
}