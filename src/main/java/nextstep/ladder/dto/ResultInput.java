package nextstep.ladder.dto;

public class ResultInput {
    private static final String ALL = "all";
    private String name;
    private boolean isAll;

    public ResultInput(String name, boolean isAll) {
        this.name = name;
        this.isAll = isAll;
    }

    public ResultInput(String name) {
        this.name = name;
        isAll = false;
        if (ALL.equals(name)) {
            isAll = true;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isAll() {
        return isAll;
    }
}
