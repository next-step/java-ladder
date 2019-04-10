package ladder.domain;

import ladder.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Winnings {
    private final List<Winning> winnings;

    public Winnings(String winnings, int countOfPerson) {
        String[] values = Utils.stringSplitWithDelimiter(winnings, ",");
        if(values.length != countOfPerson) {
            throw new IllegalArgumentException("참여인원과 결과 개수가 맞지 않습니다.");
        }
        this.winnings = Arrays.stream(values).map(Winning::new).collect(Collectors.toList());
    }

    public String winningsString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Winning winning : winnings) {
            stringBuffer.append(winning.toString());
        }
        return stringBuffer.toString();
    }

    public Winning valueOf(int index) {
        return winnings.get(index);
    }
}
