package nextstep.ladder.domain;

public class Member {
    public static final int VALID_LENGTH = 5;

    private String name;

    public String getName(){
        return name;
    }

    public void validateNameLength(String name){
        if (name.length() > VALID_LENGTH){
            throw new IllegalArgumentException(name + "의 이름이 5글자 이상입니다.");
        }
    }

    public Member(String name){
        validateNameLength(name);
        this.name = name;
    }
}