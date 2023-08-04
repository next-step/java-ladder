package ladder.control;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderControllerTest {

  @BeforeEach
  public void setUp() {
    consoleInput(
        List.of("pobi,honux,crong,jkjk",
                "7",
                "꽝,5000,꽝,3000",
                "pobi",
                "all")
            .stream()
            .collect(Collectors
                .joining(System.lineSeparator())
            )
    );
  }

  private void consoleInput(String inputString) {
    System.setIn(new ByteArrayInputStream(inputString.getBytes()));
  }

  @AfterEach
  public void wrapUp() {
    System.setIn(System.in);
  }

  @DisplayName("실행 테스트를 자동화한다, 개발시 단순반복작업을 줄이고 시간을 아끼기 위한 테스트")
  @Test
  public void ladderAppRunner() {
    LadderController.main(new String[]{});
  }
}
