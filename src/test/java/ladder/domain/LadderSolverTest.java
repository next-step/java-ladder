package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
  @DisplayName("")
  void name2() {
    Outputs outputs = testHelper(
        Set.of(
            //new Line(2, 2),
            //new Line(0, 0)
        ),
        List.of("A", "B", "C", "D"),
        List.of("철", "동", "금", "은"),
        10
    );
    final List<Integer> expect = List.of(0, 1, 2, 3);
    outputs.print();

    assertThat(outputs.getRating()).hasSameElementsAs(expect);
  }


  @Test
  @DisplayName("")
  void name3() {

    Set<Line> lines = Set.of(
        new Line(0, 0),
        new Line(2, 2),
        new Line(1, 1)
    );

    final List<Integer> expect = List.of(0, 1, 2, 3);
    final List<Integer> result = LadderSolver.calculate(4, lines);

    Scene scene = getScene(
        Ladder.of(4, 4, lines),
        List.of("1", "2", "3", "4"),
        List.of("")
    );
    for (String horizontalLine : scene.getLadderArea()) {
      LOG.info(horizontalLine);
    }
    LOG.info(System.lineSeparator());
    LOG.info(scene.prizeArea());

    //scene.

    assertThat(result).hasSameElementsAs(expect);
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


  private static Outputs testHelper(
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
    return new Outputs(scene, results, rating);
  }

  private static void validationCheck(
      Set<Line> lines,
      List<String> userNames,
      List<String> prizes) {
    assertThat(lines).isNotEmpty();
    assertThat(userNames).isNotEmpty();
    assertThat(prizes).isNotEmpty();
    assertThat(userNames).hasSize(prizes.size());
  }

}

class Outputs {

  private static final Logger LOG = LoggerFactory.getLogger(Outputs.class);

  private final Scene scene;
  private final Results results;
  private final List<Integer> rating;

  public Outputs(Scene scene, Results results, List<Integer> rating) {
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
  }
}
