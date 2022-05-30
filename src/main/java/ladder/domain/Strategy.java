package ladder.domain;

import java.util.List;

public interface Strategy {

    List<Moving> create(int countOfPerson);
}
