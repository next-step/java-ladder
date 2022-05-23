package nextstep.ladder.domain;

public class Name {
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("이름의 길이는 최대 5글자 까지 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
