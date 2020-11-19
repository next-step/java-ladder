package nextstep.ladder;

//NumberOfValudPoints를 따로 빼는건 어떨까? 메서드나 클래스
//아니면 어차피 -1 밸류만 쓰는데 얘를 바꿔
public class NumberOfParticipants {
    public static final String INPUT_VALUE_RANGE_ERR_MSG = "참여하는 사람은 2명 이상이어야 합니다.";
    public final int value;

    private NumberOfParticipants(int value) {
        if (value < 2) {
            throw new IllegalArgumentException(INPUT_VALUE_RANGE_ERR_MSG);
        }
        this.value = value;
    }

    public static NumberOfParticipants valueOf(int value) {
        return new NumberOfParticipants(value);
    }
}
