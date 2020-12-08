package ladder.domain;

import java.util.Objects;

import static ladder.domain.LadderGameConfig.AWARD_NAME_MAX_LENGTH;


public class Award {

    private String awardName;

    public Award(String awardName){
        validateAwardName(awardName);
        this.awardName = awardName;
    }

    public String getAwardName() {
        return awardName;
    }

    private void validateAwardName(String awardName) {
        if(awardName.length() > AWARD_NAME_MAX_LENGTH){
            throw new IllegalArgumentException(LadderGameErrorMessage.ILLEGAL_MAX_AWARD_NAME.getErrorMessage());
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
