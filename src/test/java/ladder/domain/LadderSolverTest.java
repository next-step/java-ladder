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


  private List<Integer> calculateGiven(int columnCount,Set<Line> lines ) {
    return LadderSolver.calculate(columnCount, lines);
  }

  private void calculateThen(List<Integer> expect, List<Integer> actual) {
    assertThat(expect).hasSameElementsAs(actual);
  }

  @Test
  @DisplayName("")
  void name() {
    calculateThen(
        List.of(0, 1, 2, 3),
        calculateGiven(
            4, Set.of()
        )
    );
  }


  @Test
  @DisplayName("")
  void name2() {
    int participateCount = 4;
    Set<Line> lines = Set.of(new Line(2, 2));

    Ladder of = Ladder.of(participateCount, 10, lines);
    List<Integer> expect = List.of(0, 1, 2, 3);

    List<Integer> result = LadderSolver.calculate(participateCount, lines);

    Scene scene = Renderer.of(of,
        Users.of(List.of("1번", "2번", "3번", "4번")),
        new Results(
            List.of("1번", "2번", "3번", "4번"),
            Users.of(List.of("1", "2", "3", "4")).getUsers()
        )).renderingScene();
    LOG.info(scene.userArea());
    for(String horizontalLine : scene.getLadderArea() ) {
      LOG.info(horizontalLine);
    }
    LOG.info(scene.prizeArea());
    assertThat(result).hasSameElementsAs(expect);
  }


  @Test
  @DisplayName("")
  void name3() {
    int participateCount = 6;
    Set<Line> lines = Set.of(new Line(2, 2),new Line(1,1));

    Ladder of = Ladder.of(participateCount, 10, lines);
    List<Integer> expect = List.of(0, 1, 2, 3);

    List<Integer> result = LadderSolver.calculate(participateCount, lines);

    Scene scene = Renderer.of(of,
        Users.of(List.of("1", "2", "3", "4","5","6")),
        new Results(
            List.of("1", "2", "3", "4","5","6"),
            Users.of(List.of("a", "b", "c", "d","e","f")).getUsers()
        )).renderingScene();
    LOG.info(scene.userArea());
    for(String horizontalLine : scene.getLadderArea() ) {
      LOG.info(horizontalLine);
    }
    LOG.info(System.lineSeparator());
    LOG.info(scene.prizeArea());

    assertThat(result).hasSameElementsAs(expect);
  }
}
