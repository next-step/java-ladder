package ladderapplication.utils;

public class DecoratingUtils {

    private static final String EMPTY = " ";
    private static final String STEP_PIECE = "-";
    private static final int NAME_SPACE = 6;
    private static final int STANDARD_SIZE = 4;
    private static final int STEP_LENGTH = 5;

    public static String getDecoratedName(String name) {
        StringBuilder sb = new StringBuilder();
        if (name.length() < STANDARD_SIZE) {
            sb.append(getRepeatCharacter(EMPTY, STANDARD_SIZE - name.length()));
        }
        sb.append(name)
                .append(getRepeatCharacter(EMPTY, NAME_SPACE - sb.length()));
        return sb.toString();
    }

    private static String getRepeatCharacter(String character, int repeatCount) {
        return character.repeat(repeatCount);
    }

    public static String getStep(boolean hasStep) {
        if (hasStep) {
            return getRepeatCharacter(STEP_PIECE, STEP_LENGTH);
        }

        return getRepeatCharacter(EMPTY, STEP_LENGTH);
    }
}
