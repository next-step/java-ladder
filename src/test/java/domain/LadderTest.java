package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    List<Participant> participants = Arrays.asList(
        new Participant(pobi),
        new Participant(honux),
        new Participant(crong),
        new Participant(jk)
    );

    // When
    Ladder ladder = new Ladder(participants, height);

    // Then
    assertThat(ladder).isNotNull();
    assertThat(ladder.getLines().size()).isEqualTo(height);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_ladder_heightIsZero_exception() {

    // Given
    String pobi = "pobi";
    String honux = "honux";
    String crong = "crong";
    String jk = "jk";
    int height = 0;

    List<Participant> participants = Arrays.asList(
        new Participant(pobi),
        new Participant(honux),
        new Participant(crong),
        new Participant(jk)
    );

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

    List<Participant> participants = Arrays.asList(
        new Participant(pobi),
        new Participant(honux),
        new Participant(crong),
        new Participant(jk)
    );

    // When
    new Ladder(participants, height);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_ladder_participantsIsNull_exception() {

    // Given
    int height = 5;

    // When
    new Ladder(null, height);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_ladder_participantsIsEmpty_exception() {

    // Given
    int height = 5;
    List<Participant> participants = new ArrayList<>();

    // When
    new Ladder(participants, height);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_ladder_participantsIsSingle_exception() {

    // Given
    String pobi = "pobi";
    int height = 5;

    List<Participant> participants = Collections.singletonList(
        new Participant(pobi)
    );

    // When
    new Ladder(participants, height);
  }
}
