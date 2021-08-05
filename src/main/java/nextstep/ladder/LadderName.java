package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderName {
    private List<String> ladderNames;
    private static final int LETTER_LIMIT = 5;
    private static final String SPACE = " ";

    public static LadderName make(String ladderNames) {
        return new LadderName(ladderNames);
    }


    private LadderName(final String ladderNames) {
        this.inputValidation(ladderNames);
        this.ladderNames = Arrays.stream(ladderNames.split(","))
                           .map(this::lengthValidation)
                           .map(this::fitLength)
                           .collect(Collectors.toList());
    }


    private String fitLength(String name) {
        if(name.length() < LETTER_LIMIT) {
            name = fitLength(SPACE.concat(name));
        }

        return name;
    }

    private String inputValidation(String ladderNames) {
        if (Objects.isNull(ladderNames) || ladderNames.equals("")) {
            throw new IllegalArgumentException("이름을 공백으로 할 수 없습니다.");
        }
        return ladderNames;
    }

    private String lengthValidation(String name) {
        if(name.length() > 5) {
            throw new StringLengthException();
        }
        return name;
    }

    public int size(){
        return this.ladderNames.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderName that = (LadderName) o;
        return Objects.equals(ladderNames, that.ladderNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderNames);
    }

    @Override
    public String toString() {
        return "LadderName{" +
                "ladderNames=" + ladderNames +
                '}';
    }
}
