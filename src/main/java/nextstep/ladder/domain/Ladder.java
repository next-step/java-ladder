package nextstep.ladder.domain;


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

  public LadderResult getLadder() {
    return new LadderResult(people.getPeopleNames(), ladderMap.getLineStrings());
  }

}
