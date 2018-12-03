package net.chandol.ladder.v1.domain.bridge;

import net.chandol.ladder.v1.domain.bridge.RandomBridgeSupplier.RandomBridgesSupplierUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static net.chandol.ladder.v1.value.Positive.pos;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomBridgeSupplierTest {

    @Test
    public void createBridges() {
        BridgesSupplier bridgesSupplier = new RandomBridgeSupplier();
        IntStream.range(0, 10).forEach(i -> {
            Bridges bridges = bridgesSupplier.createBridges(pos(5), pos(4));
            System.out.println(bridges);
        });
    }

    @Test
    public void 사다리랜덤결과_연속된결과존재() {
        List<Boolean> booleans = Arrays.asList(false, true, true);
        boolean booleansConnected = RandomBridgesSupplierUtil.isBooleansConnected(booleans);

        assertThat(booleansConnected).isTrue();
    }

    @Test
    public void 사다리랜덤결과_정상결과() {
        List<Boolean> booleans = Arrays.asList(true, false, true);
        boolean booleansConnected = RandomBridgesSupplierUtil.isBooleansConnected(booleans);

        assertThat(booleansConnected).isFalse();
    }

    @Test
    public void 랜덤값_사다리로변환(){
        List<Boolean> booleans = Arrays.asList(true, false, true);
        List<Bridge> bridges = RandomBridgesSupplierUtil.randomBooleansToBridges(booleans, 3);
        assertThat(bridges).containsExactly(Bridge.of(0, 3), Bridge.of(2, 3));
    }
}