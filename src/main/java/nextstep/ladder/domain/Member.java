package nextstep.ladder.domain;

import java.util.List;

public class Member {

    private static final String MAX_NAME_SIZE_MESSAGE = "이름은 최대 5글자만 입력할 수 있습니다.";
    private static final int MAX_NAME_SIZE = 5;
    private String name;

    public Member(String name){
        validNameSize(name);
        this.name = name;
    }

    private void validNameSize(String name){
        if(name.length() > MAX_NAME_SIZE){
            throw new IllegalArgumentException(MAX_NAME_SIZE_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
