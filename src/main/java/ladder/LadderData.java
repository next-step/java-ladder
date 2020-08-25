package ladder;

public class LadderData {

    private final Input input;
    private Names names;
    private int height;

    public LadderData(Input input) {
        this.input = input;
    }

    public void inputNames() {
        String inputNames = input.nextLine();
        names = new Names(inputNames);
    }

    public void inputHeight() {
        height = input.nextInt();
    }

    public Names getNames() {
        return names;
    }

    public int getHeight() {
        return height;
    }
}
