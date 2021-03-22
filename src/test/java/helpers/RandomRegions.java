package helpers;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum RandomRegions {
    //MOSCOW("Москва и Московская область"),
    //SAINT_PETERSBURG("Санкт-Петербург и Ленинградская область"),
    KRASNODAR("Краснодарский край"),
    NIZHNY_NOVGOROD("Нижегородская область"),
    TATARSTAN("Республика Татарстан");

    private final String name;

    RandomRegions(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public static String getRegion() {
        List<RandomRegions> regions = Stream.of(RandomRegions.values()).collect(Collectors.toList());
        return regions.get(ThreadLocalRandom.current().nextInt(regions.size())).getName();
    }
}