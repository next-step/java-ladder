package nextstep.ladder.domain;


public class Ladder {
  private People people;
  private LadderMap ladderMap;

  public Ladder(People people, Integer height) {
    this(people, new LadderMap(people.getPeopleNumber()-1, height));
  }

  public Ladder(People people, LadderMap ladderMap) {
    this.people = people;
    this.ladderMap = ladderMap;
  }

}
