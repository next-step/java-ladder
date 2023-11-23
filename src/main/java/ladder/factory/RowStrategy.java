package ladder.factory;

import ladder.domain.Row;

import java.util.List;

public interface RowStrategy {

    List<Row> rows();

}
