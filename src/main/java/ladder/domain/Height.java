package ladder.domain;

public class Height {

    private static final String ERR_SIZE_FORMAT = "숫자를 입력해주세요";
    private final int size;

    private Height(String size) {
        try {
            this.size = Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERR_SIZE_FORMAT);
        }
    }

    public static Height of(String size) {
        return new Height(size);
    }

    public int getSize() {
        return this.size;
    }
}
