package laddarGame.controller;

import laddarGame.util.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatchOfPrize {

    private final List<Prize> prizeList;

    public MatchOfPrize(String prizeList) {
        this.prizeList = Arrays.stream(Parser.nameParser(prizeList))
                .map(Prize::new)
                .collect(Collectors.toList());
    }

}
