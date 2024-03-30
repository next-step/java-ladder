package nextstep.ladder.domain;

public class Name {
    private String name;

    public Name(String name) {
        if("".equals(name)){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
}
