package nextstep.laddergame.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LinesTest {

  @Test
  @DisplayName("사다리의 높이와 인원 수를 입력받은 것을 토대로 라인을 그릴 수 있는가")
  public void create() throws Exception {
    //given
    Lines lines = Lines.createLines(5, 4);

    //when
    int dimension = lines.dimension();

    //then
    assertEquals(dimension, 20);
  }

  @ParameterizedTest
  @CsvSource({"0, 1", "1, 0", "0, 0"})
  @DisplayName("허용되지 않은 값이 들어올 경우 익셉션이 발생하는가")
  public void createException(int height, int countOfMembers) throws IOException {
    //given
    //when
    IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
        () -> Lines.createLines(height, countOfMembers));

    //then
    assertTrue(thrown.getMessage().contains("ERROR"));
  }
}