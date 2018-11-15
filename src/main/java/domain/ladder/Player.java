package domain.ladder;

public class Player {

    public static final int MAX_LENGTH_NAME = 5;

    private String name;

    public Player(String name) {
        if(name.length() > MAX_LENGTH_NAME){
            throw new IllegalArgumentException("플레이어는 5글자까지만 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
