package nextstep.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LadderName {
    private static final int LETTER_LIMIT = 5;
    private static final String SPACE = " ";

    private String laddername;

    public LadderName(String ladderName) {
        this.laddername = ladderName;
    }

    public static List<LadderName> of(String ladderNames) {
        List<LadderName> list = new ArrayList<>();
        Arrays.stream(ladderNames.split(","))
                .map(LadderName::lengthValidation)
                .map(LadderName::fitLength)
                .forEach(name -> list.add(new LadderName(name)));
        return list;
    }

    private static String fitLength(String name) {
        if(name.length() < LETTER_LIMIT) {
            name = fitLength(SPACE.concat(name));
        }
        System.out.println(name.length());

        return name;
    }

    private static String lengthValidation(String name) {
        if(name.length() > LETTER_LIMIT) {
            throw new StringLengthException();
        }
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderName that = (LadderName) o;
        return Objects.equals(laddername, that.laddername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(laddername);
    }

    @Override
    public String toString() {
        return laddername;
    }
}
