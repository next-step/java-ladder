package reladder;

public class LadderRequest {

    private String inputName;
    private String inputResult;
    private int height;

    private LadderRequest(String inputName, String inputResult, int height)  {
        this.inputName = inputName;
        this.inputResult = inputResult;
        this.height = height;
    }

    public static LadderRequest of(String inputName, String inputResult, int height) {
        return new LadderRequest(inputName, inputResult, height);
    }

    public int getHeight() {
        return height;
    }

    public String getInputName() {
        return inputName;
    }

    public String getInputResult() {
        return inputResult;
    }
}
