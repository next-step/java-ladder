package com.seok2.ladder.product.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import com.seok2.global.util.StringUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Prizes {

    private static final int MIN = 2;

    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        validate(prizes);
        this.prizes = Collections.unmodifiableList(prizes);
    }

    public static Prizes of(String prizes) {
        return Arrays.stream(StringUtils.split(prizes))
            .map(String::trim)
            .map(Prize::of)
            .collect(collectingAndThen(toList(), Prizes::new));
    }

    private void validate(List<Prize> prizes) {
        if (prizes.size() < MIN) {
            throw new IllegalArgumentException("최소 2개의 상품 입력해주세요.");
        }
    }

    public static Prizes of(List<Prize> prizes) {
        return new Prizes(prizes);
    }

    public Stream<Prize> stream() {
        return prizes.stream();
    }
}
