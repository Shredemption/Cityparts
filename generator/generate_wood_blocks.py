import os
import json

import blockstates, models, items, loottables, recipes

# === CONFIG ===
MOD_ID = "streetparts"
VARIANTS = [
    "olive",
    "verdant",
    "moon",
    "sky",
    "wisteria",
    "ebony",
]

BASE_PATH = r"./src/main/resources/"
BLOCKSTATE_DIR = os.path.join(BASE_PATH, f"assets/{MOD_ID}/blockstates")
BLOCK_MODEL_DIR = os.path.join(BASE_PATH, f"assets/{MOD_ID}/models/block")
ITEM_MODEL_DIR = os.path.join(BASE_PATH, f"assets/{MOD_ID}/models/item")
LOOT_TABLE_DIR = os.path.join(BASE_PATH, f"data/{MOD_ID}/loot_table/blocks")
RECIPE_DIR = os.path.join(BASE_PATH, f"data/{MOD_ID}/recipe")

# === Ensure directories exist ===
for path in [BLOCKSTATE_DIR, BLOCK_MODEL_DIR, ITEM_MODEL_DIR, LOOT_TABLE_DIR, RECIPE_DIR]:
    os.makedirs(path, exist_ok=True)


# === Generate files ===
for var in VARIANTS:
    log_name = f"{var}_log"
    wood_name = f"{var}_wood"
    stripped_log_name = f"stripped_{var}_log"
    stripped_wood_name = f"stripped_{var}_wood"
    planks_name = f"{var}_planks"
    stairs_name = f"{var}_stairs"
    slab_name = f"{var}_slab"
    fence_name = f"{var}_fence"
    fence_gate_name = f"{var}_fence_gate"
    door_name = f"{var}_door"
    trapdoor_name = f"{var}_trapdoor"
    pressure_plate_name = f"{var}_pressure_plate"
    button_name = f"{var}_button"
    sign_name = f"{var}_sign"
    hanging_sign_name = f"{var}_hanging_sign"

    files = {
        # blockstates
        os.path.join(BLOCKSTATE_DIR, f"{log_name}.json"): blockstates.pillar(log_name),
        os.path.join(BLOCKSTATE_DIR, f"{wood_name}.json"): blockstates.pillar(wood_name),
        os.path.join(BLOCKSTATE_DIR, f"{stripped_log_name}.json"): blockstates.pillar(stripped_log_name),
        os.path.join(BLOCKSTATE_DIR, f"{stripped_wood_name}.json"): blockstates.pillar(stripped_wood_name),
        os.path.join(BLOCKSTATE_DIR, f"{planks_name}.json"): blockstates.block(planks_name),
        os.path.join(BLOCKSTATE_DIR, f"{stairs_name}.json"): blockstates.stairs(var),
        os.path.join(BLOCKSTATE_DIR, f"{slab_name}.json"): blockstates.slab_planks(var),
        os.path.join(BLOCKSTATE_DIR, f"{fence_name}.json"): blockstates.fence(fence_name),
        os.path.join(BLOCKSTATE_DIR, f"{fence_gate_name}.json"): blockstates.fence_gate(fence_gate_name),
        os.path.join(BLOCKSTATE_DIR, f"{door_name}.json"): blockstates.door(door_name),
        os.path.join(BLOCKSTATE_DIR, f"{trapdoor_name}.json"): blockstates.trapdoor(trapdoor_name),
        os.path.join(BLOCKSTATE_DIR, f"{pressure_plate_name}.json"): blockstates.pressure_plate(pressure_plate_name),
        os.path.join(BLOCKSTATE_DIR, f"{button_name}.json"): blockstates.button(button_name),
        os.path.join(BLOCKSTATE_DIR, f"{sign_name}.json"): blockstates.sign(sign_name),
        os.path.join(BLOCKSTATE_DIR, f"{hanging_sign_name}.json"): blockstates.hanging_sign(hanging_sign_name),
        # block model
        os.path.join(BLOCK_MODEL_DIR, f"{log_name}.json"): models.pillar(log_name),
        os.path.join(BLOCK_MODEL_DIR, f"{log_name}_horizontal.json"): models.pillar_horizontal(log_name),
        os.path.join(BLOCK_MODEL_DIR, f"{wood_name}.json"): models.pillar_one_texture(log_name),
        os.path.join(BLOCK_MODEL_DIR, f"{wood_name}_horizontal.json"): models.pillar_horizontal_one_texture(log_name),
        os.path.join(BLOCK_MODEL_DIR, f"{stripped_log_name}.json"): models.pillar(stripped_log_name),
        os.path.join(BLOCK_MODEL_DIR, f"{stripped_log_name}_horizontal.json"): models.pillar_horizontal(
            stripped_log_name
        ),
        os.path.join(BLOCK_MODEL_DIR, f"{stripped_wood_name}.json"): models.pillar_one_texture(stripped_log_name),
        os.path.join(BLOCK_MODEL_DIR, f"{stripped_wood_name}_horizontal.json"): models.pillar_horizontal_one_texture(
            stripped_log_name
        ),
        os.path.join(BLOCK_MODEL_DIR, f"{planks_name}.json"): models.block(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{stairs_name}.json"): models.stairs(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{stairs_name}_inner.json"): models.stairs_inner(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{stairs_name}_outer.json"): models.stairs_outer(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}.json"): models.slab(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}_top.json"): models.slab_top(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{fence_name}_inventory.json"): models.fence_inventory(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{fence_name}_post.json"): models.fence_post(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{fence_name}_side.json"): models.fence_side(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{fence_gate_name}.json"): models.fence_gate(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{fence_gate_name}_open.json"): models.fence_gate_open(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{fence_gate_name}_wall.json"): models.fence_gate_wall(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{fence_gate_name}_wall_open.json"): models.fence_gate_wall_open(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{door_name}_bottom_left.json"): models.door_bottom_left(door_name),
        os.path.join(BLOCK_MODEL_DIR, f"{door_name}_bottom_left_open.json"): models.door_bottom_left_open(door_name),
        os.path.join(BLOCK_MODEL_DIR, f"{door_name}_bottom_right.json"): models.door_bottom_right(door_name),
        os.path.join(BLOCK_MODEL_DIR, f"{door_name}_bottom_right_open.json"): models.door_bottom_right_open(door_name),
        os.path.join(BLOCK_MODEL_DIR, f"{door_name}_top_left.json"): models.door_top_left(door_name),
        os.path.join(BLOCK_MODEL_DIR, f"{door_name}_top_left_open.json"): models.door_top_left_open(door_name),
        os.path.join(BLOCK_MODEL_DIR, f"{door_name}_top_right.json"): models.door_top_right(door_name),
        os.path.join(BLOCK_MODEL_DIR, f"{door_name}_top_right_open.json"): models.door_top_right_open(door_name),
        os.path.join(BLOCK_MODEL_DIR, f"{trapdoor_name}_open.json"): models.trapdoor_open(trapdoor_name),
        os.path.join(BLOCK_MODEL_DIR, f"{trapdoor_name}_bottom.json"): models.trapdoor_bottom(trapdoor_name),
        os.path.join(BLOCK_MODEL_DIR, f"{trapdoor_name}_top.json"): models.trapdoor_top(trapdoor_name),
        os.path.join(BLOCK_MODEL_DIR, f"{pressure_plate_name}.json"): models.pressure_plate(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{pressure_plate_name}_down.json"): models.pressure_plate_down(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{button_name}.json"): models.button(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{button_name}_pressed.json"): models.button_pressed(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{button_name}_inventory.json"): models.button_inventory(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{sign_name}.json"): models.block_particle(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{hanging_sign_name}.json"): models.block_particle(planks_name),
        # item models
        os.path.join(ITEM_MODEL_DIR, f"{log_name}.json"): items.block(log_name),
        os.path.join(ITEM_MODEL_DIR, f"{wood_name}.json"): items.block(wood_name),
        os.path.join(ITEM_MODEL_DIR, f"{stripped_log_name}.json"): items.block(stripped_log_name),
        os.path.join(ITEM_MODEL_DIR, f"{stripped_wood_name}.json"): items.block(stripped_wood_name),
        os.path.join(ITEM_MODEL_DIR, f"{planks_name}.json"): items.block(planks_name),
        os.path.join(ITEM_MODEL_DIR, f"{stairs_name}.json"): items.block(stairs_name),
        os.path.join(ITEM_MODEL_DIR, f"{slab_name}.json"): items.block(slab_name),
        os.path.join(ITEM_MODEL_DIR, f"{fence_name}.json"): items.block_inventory(fence_name),
        os.path.join(ITEM_MODEL_DIR, f"{fence_gate_name}.json"): items.block(fence_gate_name),
        os.path.join(ITEM_MODEL_DIR, f"{door_name}.json"): items.item_texture(door_name),
        os.path.join(ITEM_MODEL_DIR, f"{trapdoor_name}.json"): items.block_bottom(trapdoor_name),
        os.path.join(ITEM_MODEL_DIR, f"{pressure_plate_name}.json"): items.block(pressure_plate_name),
        os.path.join(ITEM_MODEL_DIR, f"{button_name}.json"): items.block_inventory(button_name),
        os.path.join(ITEM_MODEL_DIR, f"{sign_name}.json"): items.item_texture(sign_name),
        os.path.join(ITEM_MODEL_DIR, f"{hanging_sign_name}.json"): items.item_texture(hanging_sign_name),
        # loot tables
        os.path.join(LOOT_TABLE_DIR, f"{log_name}.json"): loottables.block_drops(log_name),
        os.path.join(LOOT_TABLE_DIR, f"{wood_name}.json"): loottables.block_drops(wood_name),
        os.path.join(LOOT_TABLE_DIR, f"{stripped_log_name}.json"): loottables.block_drops(stripped_log_name),
        os.path.join(LOOT_TABLE_DIR, f"{stripped_wood_name}.json"): loottables.block_drops(stripped_wood_name),
        os.path.join(LOOT_TABLE_DIR, f"{planks_name}.json"): loottables.block_drops(planks_name),
        os.path.join(LOOT_TABLE_DIR, f"{stairs_name}.json"): loottables.block_drops(stairs_name),
        os.path.join(LOOT_TABLE_DIR, f"{slab_name}.json"): loottables.block_drops(slab_name),
        os.path.join(LOOT_TABLE_DIR, f"{fence_name}.json"): loottables.block_drops(fence_name),
        os.path.join(LOOT_TABLE_DIR, f"{fence_gate_name}.json"): loottables.block_drops(fence_gate_name),
        os.path.join(LOOT_TABLE_DIR, f"{door_name}.json"): loottables.door(door_name),
        os.path.join(LOOT_TABLE_DIR, f"{trapdoor_name}.json"): loottables.block_drops(trapdoor_name),
        os.path.join(LOOT_TABLE_DIR, f"{pressure_plate_name}.json"): loottables.block_drops(pressure_plate_name),
        os.path.join(LOOT_TABLE_DIR, f"{button_name}.json"): loottables.block_drops(button_name),
        os.path.join(LOOT_TABLE_DIR, f"{sign_name}.json"): loottables.block_drops(sign_name),
        os.path.join(LOOT_TABLE_DIR, f"{hanging_sign_name}.json"): loottables.block_drops(hanging_sign_name),
        # recipes
        os.path.join(RECIPE_DIR, f"{wood_name}.json"): recipes.wood(log_name, wood_name),
        os.path.join(RECIPE_DIR, f"{stripped_wood_name}.json"): recipes.wood(stripped_log_name, stripped_wood_name),
        os.path.join(RECIPE_DIR, f"{planks_name}.json"): recipes.planks(log_name + "s", planks_name),
        os.path.join(RECIPE_DIR, f"{stairs_name}.json"): recipes.wooden_stairs(planks_name, stairs_name),
        os.path.join(RECIPE_DIR, f"{slab_name}.json"): recipes.wooden_slab(planks_name, slab_name),
        os.path.join(RECIPE_DIR, f"{fence_name}.json"): recipes.fence(planks_name, fence_name),
        os.path.join(RECIPE_DIR, f"{fence_gate_name}.json"): recipes.fence_gate(planks_name, fence_gate_name),
        os.path.join(RECIPE_DIR, f"{door_name}.json"): recipes.wooden_door(planks_name, door_name),
        os.path.join(RECIPE_DIR, f"{trapdoor_name}.json"): recipes.wooden_trapdoor(planks_name, trapdoor_name),
        os.path.join(RECIPE_DIR, f"{pressure_plate_name}.json"): recipes.wooden_pressure_plate(
            planks_name, pressure_plate_name
        ),
        os.path.join(RECIPE_DIR, f"{button_name}.json"): recipes.wooden_button(planks_name, button_name),
        os.path.join(RECIPE_DIR, f"{sign_name}.json"): recipes.sign(planks_name, sign_name),
        os.path.join(RECIPE_DIR, f"{hanging_sign_name}.json"): recipes.hanging_sign(planks_name, hanging_sign_name),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All wood block models + blockstate files generated successfully!")
