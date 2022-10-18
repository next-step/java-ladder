package nextstep.laddergame.domain;

import java.util.List;

public interface LadderGameInterface {
    int getResultIndex(int startIndex);

    List<Integer> getResultAll();
}
