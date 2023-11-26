package me.namuhuchutong.ladder.domain.engine;

@FunctionalInterface
public interface ScaffoldDiscriminator {

    boolean isNotCreatedBefore();
}
