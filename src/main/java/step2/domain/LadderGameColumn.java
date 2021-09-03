package step2.domain;

public class LadderGameColumn {
    private int position;
    private final String name;
    private String result;

    public LadderGameColumn(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public LadderGameColumn(int position, String name, String result) {
        this.position = position;
        this.name = name;
        this.result = result;
    }
    public void moveLeft() {this.position--;}

    public void moveRight() {this.position++;}

    public void setResult(String result) {this.result = result;}

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }
}