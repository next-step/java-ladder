package nextstep.domain.player;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGHT = 5;

    public final String name;

    public Name(String name) {
        checkValidName(name);
        this.name = name;
    }

    private void checkValidName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("빈 이름을 등록할 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGHT) {
            throw new IllegalArgumentException("이름은 최대 5글자만 가능합니다.");
        }
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if(object == this) {
            return true;
        }
        if(object == null || getClass() != object.getClass()){
            return false;
        }
        Name name = (Name) object;
        return name.getName().equals(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
