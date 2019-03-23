package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LineTest {

  @Test
  public void test_line_constructor_byCountOfPerson() {

    // Given
    int countOfPerson = 4;

    // When
    Line line = new Line(countOfPerson);

    // Then
    assertThat(line).isNotNull();
    assertThat(line.getPoints().size()).isEqualTo(countOfPerson - 1);
  }
}
