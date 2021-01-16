package ladder.entity;

public class Name {

    private static final String NAME_VALIDATION = "이름의 길이는 5 이하 이여야 합니다.";
    private int limitLength = 5;
    private String name;

    public Name(String name){
        this.name = validation(name);
    }

    protected String validation(String name){
        if( name.length() < limitLength){
            return name;
        }
        throw new IllegalArgumentException( name + ","+name.length()+ NAME_VALIDATION);
    }

    protected String getName(){
        return this.name;
    }
}
