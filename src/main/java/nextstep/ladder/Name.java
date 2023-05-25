package nextstep.ladder;

public class Name {

    private String name;

    public Name(String name){
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if("".equals(name) || name == null)
            throw new IllegalArgumentException("이름의 값이 없으면 안됩니다.");
        if(name.length() > 5){
            throw new IllegalArgumentException("이름은 최대5글자까지 가능합니다.");
        }
    }

    public String name(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
