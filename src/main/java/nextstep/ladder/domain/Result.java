package nextstep.ladder.domain;

public class Result {

    private final ResultId id;

    private String value;

    public Result(ResultId id, String value) {
        this.id = id;
        this.value = value;
    }

    public ResultId getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

}
