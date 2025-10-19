package com.shredemption.cityparts;

import org.apache.commons.lang3.tuple.Pair;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.ConfigValue;

public class CityPartsConfig {
    public static final CityPartsConfig CONFIG;
    public static final ModConfigSpec SPEC;

    static {
        Pair<CityPartsConfig, ModConfigSpec> pair = new ModConfigSpec.Builder().configure(CityPartsConfig::new);
        CONFIG = pair.getLeft();
        SPEC = pair.getRight();
    }

    public final ConfigValue<Boolean> enableMigration;

    private CityPartsConfig(ModConfigSpec.Builder builder) {
        builder.push("migration");
        enableMigration = builder
                .comment("Enable migration from old 'streetparts' ids to 'cityparts'.")
                .define("enableMigration", true);
        builder.pop();
    }
}