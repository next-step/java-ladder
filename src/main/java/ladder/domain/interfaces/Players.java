package ladder.domain.interfaces;

import ladder.domain.ns.PlayerName;
import ladder.domain.ns.Vertical;

import java.util.List;

public interface Players {
    int size();

    List<PlayerName> names();

    Vertical vertical();
}
