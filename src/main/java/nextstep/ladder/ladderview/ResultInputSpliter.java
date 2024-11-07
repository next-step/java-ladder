package nextstep.ladder.ladderview;

import java.util.function.UnaryOperator;

public class ResultInputSpliter implements UnaryOperator<String> {
    private static ResultInputSpliter splitResultInput;

    public static ResultInputSpliter getInstance() {
        if (splitResultInput == null) {
            splitResultInput = new ResultInputSpliter();
        }
        return splitResultInput;
    }

    private ResultInputSpliter() {

    }

    @Override
    public String apply(String result) {
        try {
            Integer.parseInt(result);
        } catch (IllegalArgumentException e) {
            return "꽝";
        }
        return result;
    }
}
