package me.namuhuchutong.ladder;

public class LadderResult {

    private static final String OUTPUT_FORMAT = "%s\n%s";
    private static final String SIX_RIGHT_ALIGNMENT = "%6s";

    private final Names names;

    private final Rows rows;

    public LadderResult(Names names, Rows rows) {
        this.names = names;
        this.rows = rows;
    }

    public String getResult() {
        String formattedNames = this.names.getNames(SIX_RIGHT_ALIGNMENT);
        String rowsString = this.rows.toString();
        return String.format(OUTPUT_FORMAT, formattedNames, rowsString);
    }
}
