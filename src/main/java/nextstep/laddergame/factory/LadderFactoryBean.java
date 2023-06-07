package nextstep.laddergame.factory;

import nextstep.laddergame.engine.LadderCreator;
import nextstep.laddergame.nextstep.NextStepLadderCreator;

public class LadderFactoryBean {

  public static LadderCreator createLadderFactory(int height, int width) {
    return new NextStepLadderCreator(height, width);
  }
}
