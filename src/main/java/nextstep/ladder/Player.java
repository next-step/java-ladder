package nextstep.ladder;

public class Player {
    public static final int MAX_NAME_LENGTH = 5;
    private String name;

    public Player(String name) {
        validPlayer(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validPlayer(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("이름은 공백을 허용하지 않습니다.");
        }
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("이름은 최대 " + MAX_NAME_LENGTH + "자까지 허용합니다.");
        }
    }

}
