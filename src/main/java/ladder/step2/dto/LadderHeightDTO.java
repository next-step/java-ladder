package ladder.step2.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LadderHeightDTO {
    private static final String INPUT_EXCEPTION_MESSAGE = "올바른 입력 형식이 아닙니다. 다시 입력해주세요.";
    private static final String LADDER_HEIGHT_INPUT_FORM = "[1-9][0-9]*";
    
    private final int ladderHeight;
    
    public LadderHeightDTO(String ladderHeight) {
        this.ladderHeight = parseLadderHeight(ladderHeight);
    }
    
    private static int parseLadderHeight(String ladderHeight) {
        checkLadderHeightInputForm(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }
    
    private static void checkLadderHeightInputForm(String ladderHeight) {
        Matcher matcher = Pattern.compile(LADDER_HEIGHT_INPUT_FORM).matcher(ladderHeight);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
    
    public int getLadderHeight() {
        return ladderHeight;
    }
}

