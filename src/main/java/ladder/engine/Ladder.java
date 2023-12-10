package ladder.engine;

import java.util.List;

import ladder.gilbert.domain.data.*;

public interface Ladder {

    String INDENT = " ";

    List<Result> runAll(Persons persons);

    Result run(Person person);

}
