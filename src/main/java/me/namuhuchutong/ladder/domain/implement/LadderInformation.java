package me.namuhuchutong.ladder.domain.implement;

public class LadderInformation {

    private final Names names;

    private final Rows rows;

    private final Results results;

    public LadderInformation(Names names, Rows rows, Results results) {
        this.names = names;
        this.rows = rows;
        this.results = results;
    }

    public String getNames(String format) {
        return this.names.getNames(format);
    }

    public String getRows() {
        return this.rows.toString();
    }

    public String getResults(String format) {
        return this.results.getResults(format);
    }
}
