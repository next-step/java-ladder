package ladder.model;

public class Player {

    private String name;

    public Player(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("사람에 이름을 최대5글자까지 부여할 수 있습니다");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
