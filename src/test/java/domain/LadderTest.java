package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.Test;

public class LadderTest {

  @Test
  public void test_ladder_constructor() {

    // Given
    Participants participants = new Participants(Arrays.asList(
        new Participant("pobi"),
        new Participant("honux"),
        new Participant("crong"),
        new Participant("jk")
    ));

    Results results = new Results(
        Arrays.asList(
            new Result("꽝"),
            new Result("3000"),
            new Result("꽝"),
            new Result("5000")
        )
    );

    // When
    Ladder ladder = new Ladder(participants, results);

    // Then
    assertThat(ladder).isNotNull();
  }


  @Test(expected = IllegalArgumentException.class)
  public void test_ladder_heightIsZero_exception() {

    // Given
    Participants participants = new Participants(Arrays.asList(
        new Participant("pobi"),
        new Participant("honux"),
        new Participant("crong"),
        new Participant("jk")
    ));

    Results results = new Results(
        Arrays.asList(
            new Result("꽝"),
            new Result("3000"),
            new Result("꽝"),
            new Result("5000")
        )
    );
    int height = 0;

    // When
    Ladder ladder = new Ladder(participants, results);
    ladder.create(height);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_ladder_heightIsNegative_exception() {

    // Given
    Participants participants = new Participants(Arrays.asList(
        new Participant("pobi"),
        new Participant("honux"),
        new Participant("crong"),
        new Participant("jk")
    ));

    Results results = new Results(
        Arrays.asList(
            new Result("꽝"),
            new Result("3000"),
            new Result("꽝"),
            new Result("5000")
        )
    );
    int height = -5;

    // When
    Ladder ladder = new Ladder(participants, results);
    ladder.create(height);
  }
}
