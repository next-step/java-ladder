package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ParticipantTest {

  @Test
  public void test_participant_constructor() {

    // Given
    String participantName = "pobi";

    // When
    Participant participant = new Participant(participantName);

    // Then
    assertThat(participant.toString()).isEqualTo(participantName);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_participantName_length_exception() {

    // Given
    String participantName = "pobihonux";

    // When
    new Participant(participantName);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_participantName_null_exception() {

    // When
    new Participant(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_participantName_empty_exception() {

    // Given
    String participantName = "";

    // When
    new Participant(participantName);
  }
}
