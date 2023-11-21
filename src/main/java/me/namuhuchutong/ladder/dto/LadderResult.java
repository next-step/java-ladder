package me.namuhuchutong.ladder.dto;

import me.namuhuchutong.ladder.domain.Names;
import me.namuhuchutong.ladder.domain.Results;
import me.namuhuchutong.ladder.domain.Rows;

public class LadderResult {

    private static final String OUTPUT_FORMAT = "%s\n%s\n%s";
    private static final String SIX_RIGHT_ALIGNMENT = "%6s";

    private final Names names;

    private final Rows rows;

    private final Results results;

    public LadderResult(Names names, Rows rows, Results results) {
        this.names = names;
        this.rows = rows;
        this.results = results;
    }

    public String getResult() {
        String formattedNames = this.names.getNames(SIX_RIGHT_ALIGNMENT);
        String rowsString = this.rows.toString();
        String resultsString = this.results.getResults(SIX_RIGHT_ALIGNMENT);
        return String.format(OUTPUT_FORMAT, formattedNames, rowsString, resultsString);
    }
}
