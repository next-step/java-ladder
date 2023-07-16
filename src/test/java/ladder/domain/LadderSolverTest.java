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
    Set<Line> lines = Set.of(new Line(2, 2), new Line(0, 0));

    Ladder of = Ladder.of(participateCount, 10, lines);
    final List<Integer> expect = List.of(0, 1, 2, 3);

    final List<Integer> result = LadderSolver.calculate(participateCount, lines);

    final List<String> participation = List.of("A", "B", "C", "D");
    final List<String> prizes = List.of("철","동","금","은");

    Scene scene = Renderer.of(of,
        Users.of(participation),
        new Results(
            prizes,
            Users.of(List.of("1", "2", "3", "4")).getUsers()
        )).renderingScene();
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
    int participateCount = 6;
    Set<Line> lines = Set.of(new Line(2, 2), new Line(1, 1));

    Ladder of = Ladder.of(participateCount, 10, lines);
    final List<Integer> expect = List.of(0, 1, 2, 3);

    final List<Integer> result = LadderSolver.calculate(participateCount, lines);

    Scene scene = Renderer.of(of,
        Users.of(List.of("1", "2", "3", "4", "5", "6")),
        new Results(
            List.of("1", "2", "3", "4", "5", "6"),
            Users.of(List.of("a", "b", "c", "d", "e", "f")).getUsers()
        )).renderingScene();
    LOG.info(scene.userArea());
    for (String horizontalLine : scene.getLadderArea()) {
      LOG.info(horizontalLine);
    }
    LOG.info(System.lineSeparator());
    LOG.info(scene.prizeArea());

    assertThat(result).hasSameElementsAs(expect);
  }
}
