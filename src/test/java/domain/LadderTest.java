package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LadderTest {

  @Test
  public void test_ladder_constructor() {

    // Given
    int countOfPerson = 4;
    int height = 5;

    // When
    Ladder ladder = new Ladder(countOfPerson, height);

    // Then
    assertThat(ladder).isNotNull();
    assertThat(ladder.getLines().size()).isEqualTo(height);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_ladder_heightIsZero_exception() {

    // Given
    int countOfPerson = 4;
    int height = 0;

    // When
    new Ladder(countOfPerson, height);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_ladder_heightIsNegative_exception() {

    // Given
    int countOfPerson = 4;
    int height = -5;

    // When
    new Ladder(countOfPerson, height);
  }
}
