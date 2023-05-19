package laddergame.domain.line;

import java.util.List;

public interface ConnectionStrategy {

    List<LineStatus> getConnection(int count);
}
