package nextstep.laddergame.factory;

import nextstep.laddergame.engine.strategy.LineStrategy;
import nextstep.laddergame.nextstep.strategy.LineStrategyNotTwoWay;
import nextstep.laddergame.nextstep.strategy.decorator.LineStrategyRandom;

public class LineStrategyBean {

  public static LineStrategy createLineStrategy(){
    return new LineStrategyRandom(new LineStrategyNotTwoWay());
  }
}
