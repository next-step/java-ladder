package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.Test;

public class LadderTest {

  @Test
  public void test_ladder_constructor() {

    // Given
    String pobi = "pobi";
    String honux = "honux";
    String crong = "crong";
    String jk = "jk";
    int height = 5;

    Participants participants = new Participants(Arrays.asList(
        new Participant(pobi),
        new Participant(honux),
        new Participant(crong),
        new Participant(jk)
    ));

    // When
    Ladder ladder = new Ladder(participants, height);

    // Then
    assertThat(ladder).isNotNull();
    assertThat(ladder.height()).isEqualTo(height);
  }


  @Test(expected = IllegalArgumentException.class)
  public void test_ladder_heightIsZero_exception() {

    // Given
    String pobi = "pobi";
    String honux = "honux";
    String crong = "crong";
    String jk = "jk";
    int height = 0;

    Participants participants = new Participants(Arrays.asList(
        new Participant(pobi),
        new Participant(honux),
        new Participant(crong),
        new Participant(jk)
    ));

    // When
    new Ladder(participants, height);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_ladder_heightIsNegative_exception() {

    // Given
    String pobi = "pobi";
    String honux = "honux";
    String crong = "crong";
    String jk = "jk";
    int height = -5;

    Participants participants = new Participants(Arrays.asList(
        new Participant(pobi),
        new Participant(honux),
        new Participant(crong),
        new Participant(jk)
    ));

    // When
    new Ladder(participants, height);
  }
}
