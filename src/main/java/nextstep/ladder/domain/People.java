package nextstep.ladder.domain;

public class People {
    private String name;

    public People(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("사람의 이름은 5를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
