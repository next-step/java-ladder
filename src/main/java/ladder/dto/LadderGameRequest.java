package ladder.dto;

public class LadderGameRequest {

    private String[] names;

    private int height;

    public LadderGameRequest(String[] names, int height) {
        this.names = names;
        this.height = height;
    }

    public String[] getNames() {
        return names;
    }

    public int getHeight() {
        return height;
    }
}
