package nextstep.ladder.model;

public class Result extends Name {

    public Result(String name) {
        super(name);
    }

    @Override
    protected String validation(String name) {
        return name;
    }
}
