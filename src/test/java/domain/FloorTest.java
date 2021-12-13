package domain;

import domain.strategy.RandomHorizontalLineDrawingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FloorTest {

  @Test
  @DisplayName("Floor를 생성하면 points의 개수가 주어진 참여자 수와 동일한지 검증하기 위한 테스트")
  void pointsHaveGivenNumberOfPlayers() {
    // given
    int numberOfPlayers = 5;
    RandomHorizontalLineDrawingStrategy strategy = new RandomHorizontalLineDrawingStrategy();

    // when
    Floor floor = new Floor(numberOfPlayers, strategy);

    // then
    assertThat(floor.getPoints().size()).isEqualTo(5);
  }

  @ParameterizedTest
  @CsvSource(value = {"5, 2", "6, 3"})
  @DisplayName("항상 참인 수평선 그리기 전략을 가질 때 (참가자 수/2) 만큼의 수평선을 가지게 되는지 검증하기 위한 테스트")
  void everyPointHaveHorizontalLineWhenGivenAlwaysTrueStrategy(int numberOfPlayers, int expected) {
    // when
    Floor floor = new Floor(numberOfPlayers, () -> true);

    // then
    long numberOfHorizontalLine = floor.getPoints().stream().filter(Point::isHasHorizontalLine).count();
    assertThat(numberOfHorizontalLine).isEqualTo(expected);
  }

}
