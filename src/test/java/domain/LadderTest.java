package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LadderTest {

  @Test
  public void test_ladder_contructor() {

    // Given
    int height = 5;

    // When
    Ladder ladder = new Ladder(height);

    // Then
    assertThat(ladder).isNotNull();
    assertThat(ladder.getHeight()).isEqualTo(height);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_ladder_heightIsZero_exception() {

    // Given
    int height = 0;

    // When
    new Ladder(height);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_ladder_heightIsNegative_exception() {

    // Given
    int height = -5;

    // When
    new Ladder(height);
  }
}
