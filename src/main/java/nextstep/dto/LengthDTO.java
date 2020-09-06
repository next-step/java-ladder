package nextstep.dto;

import nextstep.entity.Length;

public class LengthDTO implements DTO {

    private final int length;

    public LengthDTO(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("사다리 높이는 최소 1 단위 까지 부여할 수 있어요.");
        }
        this.length = length;
    }


    public Length of() {
        return new Length(length);
    }
}
