package ladder.domain;

import java.util.List;
import ladder.domain.strategy.NextPointGenerationStrategy;

public class Ladders {

  private final Lines lines;

  /**
   * 객체 자신이 가지는 상태 값 이상으로의 값을 통해 객체를 생성할 필요할 있는 경우는 => 정적 팩토리 메서드 활용하자.
   *
   * 생성자 안에서 Ladders에 필요한 Lines까지 호출해서 만들 경우, 인스터스 생성과 동시에
   * 완벽한 객체를 만들어 버리면 실질적으로 객체 구성요소들을 만드는 해당 메서드는 private으로 만들어지는데 그러면 테스트 하기 어려워진다.
   * => 그래서 더욱 정적 팩터리 메서드를 활용하고 객체의 생성자는 private으로 감춘다.
   *
   * => 정적 팩토리 메서드 안에서 생성자를 호출하자.
   *
   * [질문]
   * 1. 과연 Ladders가 객체 상태 값으로 Height 와 Participants를 가져도 괜찮을까?? 괜찮지 않으면 팩토리 메서드 안에서만 생명 주기를
   * 갖도록 할까?
   * 2. 생성 자체를 호출하는 곳이 해당 객체를 상태 값으로 가지는 대상이 책임을 이행하다 보니 현재 정적 팩토리 메서드가 많이 사용되고 있다
   * 괜찮을까??
   */
  private Ladders(Lines lines) {
    this.lines = lines;
  }

  public static Ladders createLadders(Height height, Participants participants, NextPointGenerationStrategy generationStrategy) {
    Lines lines = createLines(height, participants, generationStrategy);
    return new Ladders(lines);
  }

  private static Lines createLines(Height height, Participants participants,
      NextPointGenerationStrategy generationStrategy) {
    return Lines.createLines(height, participants, generationStrategy);
  }

  public int height() {
    return lines.height();
  }

  public List<Boolean> getRow(int rowNumber) {
    return lines.getRow(rowNumber).getPoints();
  }
}
