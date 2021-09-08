package step2.domain;

public class LadderGameColumn {
    private int position;
    private final String name;

    public LadderGameColumn(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public void moveLeft() {this.position--;}

    public void moveRight() {this.position++;}

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}