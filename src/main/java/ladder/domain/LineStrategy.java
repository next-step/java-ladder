package ladder.domain;

import java.util.List;

public interface LineStrategy {
    List<Boolean> getBridge();
    int countOfBridge();
    boolean canMove(int width);
}
