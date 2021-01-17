package ladder.domain;

import java.util.Optional;

public class Name {

    private static final String NAME_VALIDATION = "이름의 길이는 5 이하 이여야 합니다.";
    private int limitLength = 5;
    private String name;

    public Name(String name){
        this.name = validation(name);
    }

    protected String validation(String name){
        String checkedName = Optional.ofNullable(name)
                .filter((element -> element.length() <= limitLength))
                .orElseThrow(() -> new IllegalArgumentException(name + "," + name.length() + NAME_VALIDATION));
        return checkedName;
    }

    public String getName(){
        return this.name;
    }
}
