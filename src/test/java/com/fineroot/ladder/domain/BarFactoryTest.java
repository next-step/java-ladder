package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fineroot.ladder.utils.ExceptionMessage;
import com.fineroot.ladder.utils.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BarFactoryTest {

    @Test
    @DisplayName("BarFactory withInitValue 생성")
    void create_withInitValue() {
        BarFactory barFactory = new BarFactory(false);
        assertThat(barFactory.first().currentStep()).isFalse();
    }

    @Test
    @DisplayName("첫 단계 bar")
    void create_first() {
        BarFactory barFactory = new BarFactory(RandomUtils.getBoolean());
        assertThat(barFactory.first()).isInstanceOf(Bar.class);
    }

    @Test
    @DisplayName("중간 단계 bar")
    void next(){
        BarFactory barFactory = new BarFactory(RandomUtils.getBoolean());
        assertThat(barFactory.next(RandomUtils.getBoolean())).isInstanceOf(Bar.class);
    }

    @Test
    @DisplayName("last() 호출")
    void last() {
        BarFactory barFactory = new BarFactory(RandomUtils.getBoolean());
        assertThat(barFactory.last()).isInstanceOf(Bar.class);
    }

    @Test
    @DisplayName("last() 호출 이후 next() 호출시 예외 발생")
    void next_should_throw_exception_when_next_after_last(){
        BarFactory barFactory = new BarFactory(RandomUtils.getBoolean());
        barFactory.last();
        assertThatThrownBy(()->barFactory.next(RandomUtils.getBoolean()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.BAR_FACTORY_NEXT_AFTER_LAST.getMessage());
    }
}
