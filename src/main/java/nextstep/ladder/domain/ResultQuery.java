package nextstep.ladder.domain;

public class ResultQuery {
    private static final String ALL = "all";

    private final String name;
    private final boolean isAll;

    public ResultQuery(String name, boolean isAll) {
        this.name = name;
        this.isAll = isAll;
    }

    public ResultQuery(String input) {
        this(ALL.equalsIgnoreCase(input) ? null : input, ALL.equalsIgnoreCase(input));
    }

    public boolean isAll() {
        return isAll;
    }

    public String getName() {
        return name;
    }
}