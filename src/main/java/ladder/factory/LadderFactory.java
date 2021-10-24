package ladder.factory;

import ladder.domain.HeeSeokLadderCreator;
import ladder.domain.HeeSeokLineCreator;
import ladder.engine.LadderCreator;
import ladder.engine.LineCreator;

public class LadderFactory {
    public static LadderCreator createLadderFactory(int height, int countOfUsers){
        LineCreator lineCreator = new HeeSeokLineCreator();
        return new HeeSeokLadderCreator(lineCreator);
    }

}
