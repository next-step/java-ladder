package nextstep.ladder.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import nextstep.ladder.domain.LadderPrize;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Point;

public class ResultView {

  public void print(String result) {
    System.out.println(result);
  }

  public void printLadder(LadderResult ladder, LadderPrize prize) {
    System.out.println(ladder.getPeopleNames().stream().map(name -> String.format("%-5s", name)).collect(Collectors.joining(" ")));
    ladder.getLadderResults().forEach(line -> System.out.println(getLineString(line.getPoints())));
    System.out.println(prize.getPrizes().stream().map(prizeName -> String.format("%-5s", prizeName)).collect(Collectors.joining(" ")));
  }

  public void printResultByName(Map<Person, String> prize) {
    if(prize.size() == 1){
      prize.forEach((person, prizeName) -> System.out.println(prizeName));
      return ;
    }
    prize.forEach((person, prizeName) -> System.out.println(person.getName() + " : " + prizeName));
  }


  private String getLineString(List<Point> points) {
    return String.format("|%s|", points.stream().map(point -> {
      if(point.isNotBridge()){
        return "     ";
      }
      return "-----";
    })
        .collect(Collectors.joining("|")));
  }
}
