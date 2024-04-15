package nextstep.ladder.domain;


import java.util.LinkedHashMap;
import java.util.Map;

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
    Map<Person, String> result = new LinkedHashMap<>();
    people.getPeople().forEach(person -> result.put(person, prize.getPrizes().get(ladderMap.move(people.getPeople().indexOf(person)))));
    return result;
  }

}
