package ladder.model;

public class Name {

    private static final int MAX_LENGTH = 5;

    private String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name){
        if(name.length() > MAX_LENGTH){
            throw new IllegalArgumentException("이름은 최대 5글자입니다.");
        }
    }
}
