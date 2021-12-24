package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(String text, int countOfParticipant) {
        this(Arrays.stream(text.split(","))
                .map(Prize::new)
                .collect(Collectors.toList()));
        checkValidation(countOfParticipant);
    }

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    private void checkValidation(int countOfParticipant) {
        if (this.prizes.size() != countOfParticipant) {
            throw new IllegalArgumentException("size of prizes should match with size of participants.");
        }
    }

    public List<String> getPrizeNames() {
        return this.prizes.stream().map(Prize::getName).collect(Collectors.toList());
    }

    public String getPrizeName(int index) {
        return this.prizes.get(index).getName();
    }
}
