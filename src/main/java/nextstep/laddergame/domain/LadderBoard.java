package nextstep.laddergame.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderBoard {
  private final Ladder ladder;
  private final Award award;

  public LadderBoard(Ladder ladder, Award award) {
    this.ladder = ladder;
    this.award = award;
  }

  public Ladder ladder() {
    return this.ladder;
  }

  public Award award() {
    return this.award;
  }

  public String findOne(Name member) {
    return award.prize(ladder()
        .match(member))
        .name();
  }

  public Map<Name, Name> findAll() {
    return IntStream.range(0, ladder.members().size())
        .boxed()
        .collect(Collectors.toMap(
            this::memberName,
            this::prizeName
        ));
  }

  private Name prizeName(Integer index) {
    return award.prizes(ladder.matches(
        ladder().members()))
        .prize(index);
  }

  private Name memberName(Integer index) {
    return ladder.members()
        .names()
        .get(index);
  }
}
