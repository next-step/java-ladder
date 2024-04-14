package ladder.service;

import ladder.domain.Ladder;
import ladder.domain.Row;
import ladder.dto.PrizeDto;
import ladder.dto.StatusDto;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LadderGameServiceTest {
  private final List<String> names = List.of(
          "java",
          "C",
          "C++"
  );

  private final List<String> prizeTexts = List.of(
          "1000",
          "10000",
          "100"
  );

  @Test
  void setLadderTest() throws NoSuchFieldException, IllegalAccessException {
    LadderGameService ladderGameService = new LadderGameService();
    ladderGameService.setLadder(names.size() - 1, 1, (size, y) -> Row.of(List.of(true, false), y));

    Ladder result = getThreadLocalLadder(ladderGameService);
    assertThat(result).isEqualTo(Ladder.from(new int[][]{
            {1, 0},
    }));
  }

  @Test
  void statusTest() throws NoSuchFieldException, IllegalAccessException {
    LadderGameService ladderGameService = new LadderGameService();
    setThreadLocalLadder(ladderGameService, Ladder.from(
            new int[][]{
                    {0, 1},
                    {1, 0},
                    {0, 0},
                    {1, 0}
            }));
    StatusDto result = ladderGameService.status(names, prizeTexts);

    assertThat(result).isEqualTo(
            new StatusDto(
                    List.of(
                            "java",
                            "C",
                            "C++"
                    ),
                    Ladder.from(
                            new int[][]{
                                    {0, 1},
                                    {1, 0},
                                    {0, 0},
                                    {1, 0}
                            }),
                    List.of(
                            "1000",
                            "10000",
                            "100"
                    )
            )
    );
  }

  @Test
  void playTest() throws NoSuchFieldException, IllegalAccessException {
    LadderGameService ladderGameService = new LadderGameService();
    setThreadLocalLadder(ladderGameService, Ladder.from(
            new int[][]{
                    {0, 1},
                    {1, 0},
                    {0, 0},
                    {1, 0}
            }));

    Map<String, PrizeDto> results = ladderGameService.play(names, prizeTexts);

    assertThat(results).isEqualTo(
            Map.of(
                    "java", new PrizeDto("1000"),
                    "C", new PrizeDto("100"),
                    "C++", new PrizeDto("10000")
            )
    );
  }

  private void setThreadLocalLadder(LadderGameService ladderGameService, Ladder ladder) throws IllegalAccessException, NoSuchFieldException {
    Field threadLocal = LadderGameService.class.getDeclaredField("threadLocal");
    threadLocal.setAccessible(true);
    ThreadLocal<Ladder> mockedThreadLocal = ThreadLocal.withInitial(() -> ladder);
    threadLocal.set(ladderGameService, mockedThreadLocal);
  }

  private Ladder getThreadLocalLadder(LadderGameService ladderGameService) throws IllegalAccessException, NoSuchFieldException {
    Field threadLocal = LadderGameService.class.getDeclaredField("threadLocal");
    threadLocal.setAccessible(true);
    ThreadLocal<Ladder> threadLocalLadder = (ThreadLocal<Ladder>) threadLocal.get(ladderGameService);
    return threadLocalLadder.get();
  }
}

