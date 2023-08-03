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
    final int participateCount = 4;
    Set<Line> lines = Set.of(
        new Line(2, 2),
        new Line(0, 0)
    );

    final List<Integer> expect = List.of(0, 1, 2, 3);
    final List<Integer> result = LadderSolver.calculate(participateCount, lines);

    Scene scene = getScene(
        Ladder.of(participateCount, 10, lines),
        List.of("A", "B", "C", "D"),
        List.of("철", "동", "금", "은")
    );
    Results results = getResults(
        List.of("A", "B", "C", "D"),
        List.of("철", "동", "금", "은")
    );
    LOG.info(scene.userArea());
    for (String horizontalLine : scene.getLadderArea()) {
      LOG.info(horizontalLine);
    }
    LOG.info("\n\r");
    LOG.info(scene.prizeArea());
    assertThat(result).hasSameElementsAs(expect);
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
}
