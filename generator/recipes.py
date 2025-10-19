MOD_ID = "cityparts"


def wood(log, wood):
    return {
        "type": "minecraft:crafting_shaped",
        "category": "building",
        "group": "bark",
        "key": {"#": {"item": f"{MOD_ID}:{log}"}},
        "pattern": ["##", "##"],
        "result": {"count": 3, "id": f"{MOD_ID}:{wood}"},
    }


def planks(logs_tag, planks):
    return {
        "type": "minecraft:crafting_shapeless",
        "category": "building",
        "group": "planks",
        "ingredients": [{"tag": f"{MOD_ID}:{logs_tag}"}],
        "result": {"count": 4, "id": f"{MOD_ID}:{planks}"},
    }


def wooden_stairs(planks, stairs):
    return {
        "type": "minecraft:crafting_shaped",
        "category": "building",
        "group": "wooden_stairs",
        "key": {"#": {"item": f"{MOD_ID}:{planks}"}},
        "pattern": ["#  ", "## ", "###"],
        "result": {"count": 4, "id": f"{MOD_ID}:{stairs}"},
    }


def wooden_slab(planks, slab):
    return {
        "type": "minecraft:crafting_shaped",
        "category": "building",
        "group": "wooden_slab",
        "key": {"#": {"item": f"{MOD_ID}:{planks}"}},
        "pattern": ["###"],
        "result": {"count": 6, "id": f"{MOD_ID}:{slab}"},
    }


def fence(planks, fence):
    return {
        "type": "minecraft:crafting_shaped",
        "category": "misc",
        "group": "wooden_fence",
        "key": {"#": {"item": "minecraft:stick"}, "W": {"item": f"{MOD_ID}:{planks}"}},
        "pattern": ["W#W", "W#W"],
        "result": {"count": 3, "id": f"{MOD_ID}:{fence}"},
    }


def fence_gate(planks, fence_gate):
    return {
        "type": "minecraft:crafting_shaped",
        "category": "redstone",
        "group": "wooden_fence_gate",
        "key": {"#": {"item": "minecraft:stick"}, "W": {"item": f"{MOD_ID}:{planks}"}},
        "pattern": ["#W#", "#W#"],
        "result": {"count": 1, "id": f"{MOD_ID}:{fence_gate}"},
    }


def wooden_door(planks, door):
    return {
        "type": "minecraft:crafting_shaped",
        "category": "redstone",
        "group": "wooden_door",
        "key": {"#": {"item": f"{MOD_ID}:{planks}"}},
        "pattern": ["##", "##", "##"],
        "result": {"count": 3, "id": f"{MOD_ID}:{door}"},
    }


def wooden_trapdoor(planks, trapdoor):
    return {
        "type": "minecraft:crafting_shaped",
        "category": "redstone",
        "group": "wooden_trapdoor",
        "key": {"#": {"item": f"{MOD_ID}:{planks}"}},
        "pattern": ["###", "###"],
        "result": {"count": 2, "id": f"{MOD_ID}:{trapdoor}"},
    }


def wooden_pressure_plate(planks, pressure_plate):
    return {
        "type": "minecraft:crafting_shaped",
        "category": "redstone",
        "group": "wooden_pressure_plate",
        "key": {"#": {"item": f"{MOD_ID}:{planks}"}},
        "pattern": ["##"],
        "result": {"count": 1, "id": f"{MOD_ID}:{pressure_plate}"},
    }


def wooden_button(planks, button):
    return {
        "type": "minecraft:crafting_shapeless",
        "category": "redstone",
        "group": "wooden_button",
        "ingredients": [{"item": f"{MOD_ID}:{planks}"}],
        "result": {"count": 1, "id": f"{MOD_ID}:{button}"},
    }


def traffic_sign(result):
    return {
        "type": "minecraft:stonecutting",
        "ingredient": {"item": "minecraft:iron_ingot"},
        "result": {"count": 1, "id": f"{MOD_ID}:{result}"},
    }


def one_from_tag_stonecutter(tag, result):
    return {
        "type": "minecraft:stonecutting",
        "ingredient": {"tag": f"{MOD_ID}:{tag}"},
        "result": {"count": 1, "id": f"{MOD_ID}:{result}"},
    }


def two_from_tag_stonecutter(tag, result):
    return {
        "type": "minecraft:stonecutting",
        "ingredient": {"tag": f"{MOD_ID}:{tag}"},
        "result": {"count": 2, "id": f"{MOD_ID}:{result}"},
    }


def building_slab(block, slab):
    return {
        "type": "minecraft:crafting_shaped",
        "category": "building",
        "key": {"#": {"item": f"{MOD_ID}:{block}"}},
        "pattern": ["###"],
        "result": {"count": 6, "id": f"{MOD_ID}:{slab}"},
    }


def building_slab_stonecutter(block, slab):
    return {
        "type": "minecraft:stonecutting",
        "ingredient": {"item": f"{MOD_ID}:{block}"},
        "result": {"count": 2, "id": f"{MOD_ID}:{slab}"},
    }


def building_stairs(block, stairs):
    return {
        "type": "minecraft:crafting_shaped",
        "category": "building",
        "key": {"#": {"item": f"{MOD_ID}:{block}"}},
        "pattern": ["#  ", "## ", "###"],
        "result": {"count": 4, "id": f"{MOD_ID}:{stairs}"},
    }


def building_stairs_stonecutter(block, stairs):
    return {
        "type": "minecraft:stonecutting",
        "ingredient": {"item": f"{MOD_ID}:{block}"},
        "result": {"count": 1, "id": f"{MOD_ID}:{stairs}"},
    }


def building_wall(block, wall):
    return {
        "type": "minecraft:crafting_shaped",
        "category": "misc",
        "key": {"#": {"item": f"{MOD_ID}:{block}"}},
        "pattern": ["###", "###"],
        "result": {"count": 6, "id": f"{MOD_ID}:{wall}"},
    }


def building_wall_stonecutter(block, wall):
    return {
        "type": "minecraft:stonecutting",
        "ingredient": {"item": f"{MOD_ID}:{block}"},
        "result": {"count": 1, "id": f"{MOD_ID}:{wall}"},
    }


def pavement(block, result):
    return {
        "type": "minecraft:crafting_shaped",
        "group": "pavement",
        "category": "building",
        "pattern": ["xxx", "xxx", "xxx"],
        "key": {"x": {"item": f"{block}"}},
        "result": {"id": f"{MOD_ID}:{result}", "count": 9},
    }


def brick_variant(additive, result):
    return {
        "type": "minecraft:crafting_shapeless",
        "group": "pavement",
        "category": "building",
        "ingredients": [{"item": "minecraft:bricks"}, {"item": f"{additive}"}],
        "result": {"id": f"{MOD_ID}:{result}", "count": 1},
    }


def sign(planks, result):
    return {
        "type": "minecraft:crafting_shaped",
        "category": "misc",
        "group": "wooden_sign",
        "key": {"#": {"item": f"{MOD_ID}:{planks}"}, "X": {"item": "minecraft:stick"}},
        "pattern": ["###", "###", " X "],
        "result": {"count": 3, "id": f"{MOD_ID}:{result}"},
    }


def hanging_sign(stripped_log, result):
    return {
        "type": "minecraft:crafting_shaped",
        "category": "misc",
        "group": "hanging_sign",
        "key": {"#": {"item": f"{MOD_ID}:{stripped_log}"}, "X": {"item": "minecraft:chain"}},
        "pattern": ["X X", "###", "###"],
        "result": {"count": 6, "id": f"{MOD_ID}:{result}"},
    }
