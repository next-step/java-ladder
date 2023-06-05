package nextstep.laddergame.engine;

import java.util.List;

public interface Ladder {

  GameResult play(Members members, Prizes prizes);

  List<Row> getRows();
}
