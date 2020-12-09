package ladder.domain;

import java.util.Objects;


public class Award {

    private static final int AWARD_NAME_MAX_LENGTH = 5;
    private String awardName;

    private Award(String awardName){
        validateAwardName(awardName);
        this.awardName = awardName;
    }

    public static Award from(String awardName){
        return new Award(awardName);
    }

    public String getAwardName() {
        return awardName;
    }

    private void validateAwardName(String awardName) {
        if(awardName.length() > AWARD_NAME_MAX_LENGTH){
            throw new IllegalArgumentException("실행결과 이름은 최대 "+AWARD_NAME_MAX_LENGTH+" 글자 입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Award award = (Award) o;
        return Objects.equals(awardName, award.awardName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(awardName);
    }
}
