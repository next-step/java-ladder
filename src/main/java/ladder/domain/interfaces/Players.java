package ladder.domain.interfaces;

import ladder.domain.wrapper.PlayerName;
import ladder.domain.ns.NsVertical;

import java.util.List;

public interface Players {
    int size();

    List<PlayerName> names();

    Vertical vertical();
}
