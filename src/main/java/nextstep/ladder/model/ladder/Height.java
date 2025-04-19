package nextstep.ladder.model.ladder;

import java.util.Objects;

public class Height {
    private final int value;
    
    public Height(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("높이는 양수여야 합니다: " + value);
        }
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height = (Height) o;
        return value == height.value;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
} 
