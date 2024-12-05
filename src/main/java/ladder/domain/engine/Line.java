package ladder.domain.engine;

import java.util.List;

public interface Line {

    int move(int position);

    List<Boolean> points();

}
