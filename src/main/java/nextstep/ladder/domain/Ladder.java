package nextstep.ladder.domain;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
  private People people;
  private LadderMap ladderMap;

  public Ladder(People people, int height, BooleanGenerator booleanGenerator) {
    this(people, new LadderMap(people.getPeopleNumber()-1, height, booleanGenerator));
  }

  public Ladder(People people, LadderMap ladderMap) {
    this.people = people;
    this.ladderMap = ladderMap;
  }

  public LadderResult getGameResult(LadderPrize prize) {
    return new LadderResult(doLadderGame(prize), ladderMap.getLine());
  }

  private  Map<Person, String> doLadderGame(LadderPrize prize) {
    return streamByPeopleIndex().collect(Collectors.toMap(
            index -> people.findPersonByIndex(index),
            index -> prize.findPrize(ladderMap.move(index)),
            (a,b)->a,
            LinkedHashMap::new
    ));
  }

  private Stream<Integer> streamByPeopleIndex(){
    return IntStream.range(0, people.getPeopleNumber()).boxed();
  }

}
