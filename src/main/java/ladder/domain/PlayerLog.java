package ladder.domain;

public class PlayerLog {

    private String name;
    private int position;

    public PlayerLog(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

}
