package nextstep.ladder.dto;

import java.util.List;

public class LadderResult {
    private final List<String> names;
    private final List<RowDto> rows;

    private LadderResult(List<String> names, List<RowDto> rows) {
        this.names = names;
        this.rows = rows;
    }

    public static LadderResult of(List<String> names, List<RowDto> rows) {
        return new LadderResult(names, rows);
    }

    public List<String> getNames() {
        return names;
    }

    public List<RowDto> getRows() {
        return rows;
    }
}
