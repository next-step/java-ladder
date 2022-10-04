package laddergame.domain;

public class PersonName {
    String name;

    public PersonName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("빈 값은 입력될 수 없습니다.");
        }

        if(name.length() > 5 ){
            throw new IllegalArgumentException("이름은 최대 5글자까지 입력할 수 있습니다.");
        }

    }

}
