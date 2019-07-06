package ladder.domain.strategy;

import ladder.domain.LineStrategy;

public class LineEvenStrategy implements LineStrategy {
    @Override
    public Boolean putPoint(int position) {
         return position % 2 == 0;
    }
}
