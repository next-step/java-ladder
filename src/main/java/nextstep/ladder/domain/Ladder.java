package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
  private People people;
  private LadderMap ladderMap;

  public Ladder(People people, Integer height) {
    this(people, new LadderMap(people.getPeopleNumber(), height));
  }

  public Ladder(People people, LadderMap ladderMap) {
    this.people = people;
    this.ladderMap = ladderMap;
  }

}
