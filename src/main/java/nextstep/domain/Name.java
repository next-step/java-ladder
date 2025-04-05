package nextstep.domain;

public class Name {
    private static final int MAX_NAME_LENGHT = 5;
    public final String name;

    public Name(String name) {
        checkValidName(name);
        this.name = name;
    }

    private void checkValidName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("빈 이름을 등록할 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGHT) {
            throw new IllegalArgumentException("이름은 최대 5글자만 가능합니다.");
        }
    }

    public String getName(){
        return name;
    }
}
