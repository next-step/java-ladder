package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import ladder.present.Renderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LadderSolverTest {

  private static final Logger LOG = LoggerFactory.getLogger(LadderSolverTest.class);

  @Test
  @DisplayName("빈 사다리에서의 등수 계산을 검증한다. 0-1-2-3 결과가 나와야한다")
  void 빈_사다리() {
    LadderOutputs ladderOutputs = testHelper(
        Collections.emptySet(),
        List.of("A", "B", "C", "D"),
        List.of("철", "동", "금", "은"),
        10
    );
    final List<Integer> expect = List.of(0, 1, 2, 3);
    ladderOutputs.print();
    assertThat(ladderOutputs.getRating())
        .as("")
        .isEqualTo(expect);
  }

  @Test
  @DisplayName("1-0-3-2 결과가 나와야한다")
  void 테스트_1_0_3_2_순서로_나와야한다() {

    LadderOutputs ladderOutputs = testHelper(
        Set.of(
            new Line(0, 0),
            new Line(2, 0)
        ),
        List.of("A", "B", "C", "D"),
        List.of("철", "동", "금", "은"),
        10
    );
    ladderOutputs.print();
    final List<Integer> expect = List.of(1, 0, 3, 2);
    assertThat(ladderOutputs.getRating()).isEqualTo(expect);
  }

  private static LadderOutputs testHelper(
      Set<Line> lines,
      List<String> userNames,
      List<String> prizes,
      int rowMax
  ) {
    validationCheck(lines, userNames, prizes);
    final int participateCount = userNames.size();

    Scene scene = getScene(
        Ladder.of(participateCount, rowMax, lines),
        userNames,
        prizes
    );
    Results results = getResults(userNames, prizes);
    List<Integer> rating = LadderSolver.calculate(participateCount, lines);
    return new LadderOutputs(scene, results, rating);
  }

  private static void validationCheck(
      Set<Line> lines,
      List<String> userNames,
      List<String> prizes) {
    assertThat(lines).isNotNull();
    assertThat(userNames).isNotEmpty();
    assertThat(prizes).isNotEmpty();
    assertThat(userNames).hasSize(prizes.size());
  }

  private static Scene getScene(Ladder ladder, List<String> usersNames, List<String> prizes) {
    Scene scene = Renderer.of(ladder,
        Users.of(usersNames),
        new Results(
            prizes,
            Users.of(usersNames).getUsers()
        )
    ).renderingScene();
    return scene;
  }

  private static Results getResults(List<String> usersNames, List<String> prizes) {
    return new Results(
        prizes,
        Users.of(usersNames).getUsers()
    );
  }

}

class LadderOutputs {

  private static final Logger LOG = LoggerFactory.getLogger(LadderOutputs.class);

  private final Scene scene;
  private final Results results;
  private final List<Integer> rating;

  public LadderOutputs(Scene scene, Results results, List<Integer> rating) {
    this.scene = scene;
    this.results = results;
    this.rating = rating;
  }

  public Scene getScene() {
    return scene;
  }

  public Results getResults() {
    return results;
  }

  public List<Integer> getRating() {
    return rating;
  }

  public void print() {
    LOG.info(this.getScene().userArea());
    for (String horizontalLine : this.getScene().getLadderArea()) {
      LOG.info(horizontalLine);
    }
    LOG.info(this.scene.prizeArea());
    for (String rate : this.results.findAllPrizesByUserOrAll("all")) {
      LOG.info(rate);
    }
    for (int rate : this.rating) {
      LOG.info("[rating : {}]", rate);
    }
  }
}
