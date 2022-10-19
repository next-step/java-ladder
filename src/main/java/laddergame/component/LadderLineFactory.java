package laddergame.component;

import laddergame.domain.LadderLine;

@FunctionalInterface
public interface LadderLineFactory {

    LadderLine createLadderLine(int numberOfColumns);

}
