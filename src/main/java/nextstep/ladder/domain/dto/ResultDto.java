package nextstep.ladder.domain.dto;

import java.util.List;

public class ResultDto {
    private final List<String> names;
    private final List<RowDto> rows;

    private ResultDto(final List<String> names, final List<RowDto> rows) {
        this.names = names;
        this.rows = rows;
    }

    public static ResultDto of(final List<String> names, final List<RowDto> rows) {
        return new ResultDto(names, rows);
    }

    public List<String> getNames() {
        return names;
    }

    public List<RowDto> getRows() {
        return rows;
    }
}
