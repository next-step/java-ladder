package nextstep.ladder;

import nextstep.ladder.domain.entity.Point;
import nextstep.ladder.domain.service.LadderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderServiceTest {

  private LadderService ladderService = new LadderService();

  @ParameterizedTest
  @CsvSource(value = {"true:false", "false:true"}, delimiter = ':')
  @DisplayName("이전 사다리에 길이 있다면 길을 만들지않고, 이전 사다리에 길이 없다면 길을 만든다.")
  void createPoint(boolean input, boolean result) {
    Point prevPoint = new Point(input);

    Point nowPoint = ladderService.createPoint(prevPoint);
    assertEquals(result, nowPoint.hasWay());
  }
}