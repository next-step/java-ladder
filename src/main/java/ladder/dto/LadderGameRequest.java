package ladder.dto;

public class LadderGameRequest {

    private String[] names;

    private int height;

    public LadderGameRequest(String[] names, int height) {
        this.names = names;
        this.height = height;
    }

    public String[] names() {
        return names;
    }

    public int height() {
        return height;
    }
}
