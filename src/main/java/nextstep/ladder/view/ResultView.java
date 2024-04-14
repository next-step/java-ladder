package nextstep.ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Point;

public class ResultView {

  public void print(String result) {
    System.out.println(result);
  }

  public void printLadder(LadderResult ladder) {
    System.out.println(ladder.getPeopleNames().stream().map(name -> String.format("%-5s", name)).collect(Collectors.joining(" ")));
    ladder.getLadderResults().forEach(line -> System.out.println(getLineString(line.getPoints())));
  }


  private String getLineString(List<Point> points) {
    return String.format("|%s|", points.stream().map(point -> point.isNotBridge() ? "     " : "-----")
        .collect(Collectors.joining("|")));
  }
}
