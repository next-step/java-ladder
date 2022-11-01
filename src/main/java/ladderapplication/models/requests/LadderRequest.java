package ladderapplication.models.requests;

public class LadderRequest {

    private final int height;

    private LadderRequest(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public static LadderRequest of(int height) {
        return new LadderRequest(height);
    }

}
