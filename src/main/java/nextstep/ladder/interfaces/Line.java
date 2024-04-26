package nextstep.ladder.interfaces;

import nextstep.ladder.domain.Rung;

import java.util.List;

public interface Line {
    int move(int position);

    List<Rung> getRungs();
}
