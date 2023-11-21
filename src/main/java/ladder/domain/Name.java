package ladder.domain;

import java.util.Objects;

public class Name {

    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final String PATTERN_CONTAINS_NUMBER_OR_SPECIAL_CHARACTERS = "^.*[0-9!@#$%^&*()\"\\[\\];',.<>/?\\-_=+{}:].*$";
    private final String name;

    public Name(String name){
        inputValidation(name);
        this.name=  name;
    }

    private void inputValidation(String name) {
        if(name.length() > MAXIMUM_NAME_LENGTH){
            throw new IllegalArgumentException("이름은 최대 5가질 수 있다.");
        }

        if(name.matches(PATTERN_CONTAINS_NUMBER_OR_SPECIAL_CHARACTERS)){
            throw new IllegalArgumentException("이름에 특수 기호나 숫자가 들어갈 수 없다");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
