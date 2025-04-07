package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

  @DisplayName("참가자 수와 높이에 맞게 사다리 생성")
  @Test
  void createLadder() {
    Players players = Players.from("pobi,honux,crong,jk");
    int height = 5;
    Ladder ladder = new Ladder(players, height);

    assertThat(ladder.getHeight()).isEqualTo(height);
    assertThat(ladder.getPlayers()).isEqualTo(players);
  }

  @DisplayName("사다리 라인 조회")
  @Test
  void getLine() {
    Players players = Players.from("pobi,honux,crong,jk");
    int height = 5;
    Ladder ladder = new Ladder(players, height);

    assertThat(ladder.getLine(0)).isNotNull();
    assertThat(ladder.getLines().size()).isEqualTo(height);
  }

  @DisplayName("3명의 참가자와 3 높이의 사다리 생성")
  @Test
  void createLadderWithThreePlayersAndThreeHeight() {
    String names = "pobi,honux,crong";
    int height = 3;

    Players players = Players.from(names);
    Ladder ladder = new Ladder(players, height);

    assertThat(ladder.getHeight()).isEqualTo(height);
    assertThat(ladder.getPlayers()).isEqualTo(players);
    assertThat(ladder.getLines().size()).isEqualTo(height);

    // 각 라인의 사이즈 검증
    for (int i = 0; i < height; i++) {
      Line line = ladder.getLine(i);
      assertThat(line.getPointsSize()).isEqualTo(players.size() - 1);
    }
  }

  @DisplayName("2명의 참가자와 2 높이의 사다리 생성")
  @Test
  void createLadderWithTwoPlayersAndTwoHeight() {
    String names = "a,b";
    int height = 2;

    Players players = Players.from(names);
    Ladder ladder = new Ladder(players, height);

    assertThat(ladder.getHeight()).isEqualTo(height);
    assertThat(ladder.getPlayers()).isEqualTo(players);
    assertThat(ladder.getLines().size()).isEqualTo(height);

    // 각 라인의 사이즈 검증
    for (int i = 0; i < height; i++) {
      Line line = ladder.getLine(i);
      assertThat(line.getPointsSize()).isEqualTo(players.size() - 1);
    }
  }

  @DisplayName("5명의 참가자와 10 높이의 사다리 생성")
  @Test
  void createLadderWithFivePlayersAndTenHeight() {
    String names = "one,two,three,four,five";
    int height = 10;

    Players players = Players.from(names);
    Ladder ladder = new Ladder(players, height);

    assertThat(ladder.getHeight()).isEqualTo(height);
    assertThat(ladder.getPlayers()).isEqualTo(players);
    assertThat(ladder.getLines().size()).isEqualTo(height);

    // 각 라인의 사이즈 검증
    for (int i = 0; i < height; i++) {
      Line line = ladder.getLine(i);
      assertThat(line.getPointsSize()).isEqualTo(players.size() - 1);
    }
  }
}
