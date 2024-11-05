package nextstep.ladder.ladderview;

public class ResultInputSpliter implements InputSpliter {
    private static ResultInputSpliter splitResultInput;

    public static ResultInputSpliter getInstance() {
        if(splitResultInput == null) {
            splitResultInput = new ResultInputSpliter();
        }
        return splitResultInput;
    }

    private ResultInputSpliter() {

    }

    @Override
    public String checkValidInput(String result) {
        try {
            Integer.parseInt(result);
        } catch(IllegalArgumentException e) {
            return "꽝";
        }
        return result;
    }
}
