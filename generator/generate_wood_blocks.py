import os
import json

import blockstates, models, items, loottables

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

# === Ensure directories exist ===
for path in [BLOCKSTATE_DIR, BLOCK_MODEL_DIR, ITEM_MODEL_DIR, LOOT_TABLE_DIR]:
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
    button_name = f"{var}_button"

    files = {
        # blockstates
        os.path.join(BLOCKSTATE_DIR, f"{log_name}.json"): blockstates.pillar(log_name),
        os.path.join(BLOCKSTATE_DIR, f"{wood_name}.json"): blockstates.pillar(wood_name),
        os.path.join(BLOCKSTATE_DIR, f"{stripped_log_name}.json"): blockstates.pillar(stripped_log_name),
        os.path.join(BLOCKSTATE_DIR, f"{stripped_wood_name}.json"): blockstates.pillar(stripped_wood_name),
        os.path.join(BLOCKSTATE_DIR, f"{planks_name}.json"): blockstates.block(planks_name),
        os.path.join(BLOCKSTATE_DIR, f"{stairs_name}.json"): blockstates.stairs(var),
        os.path.join(BLOCKSTATE_DIR, f"{slab_name}.json"): blockstates.slab(var),
        os.path.join(BLOCKSTATE_DIR, f"{button_name}.json"): blockstates.button(button_name),
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
        os.path.join(BLOCK_MODEL_DIR, f"{button_name}.json"): models.button(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{button_name}_pressed.json"): models.button_pressed(planks_name),
        os.path.join(BLOCK_MODEL_DIR, f"{button_name}_inventory.json"): models.button_inventory(planks_name),
        # item models
        os.path.join(ITEM_MODEL_DIR, f"{log_name}.json"): items.block(log_name),
        os.path.join(ITEM_MODEL_DIR, f"{wood_name}.json"): items.block(wood_name),
        os.path.join(ITEM_MODEL_DIR, f"{stripped_log_name}.json"): items.block(stripped_log_name),
        os.path.join(ITEM_MODEL_DIR, f"{stripped_wood_name}.json"): items.block(stripped_wood_name),
        os.path.join(ITEM_MODEL_DIR, f"{planks_name}.json"): items.block(planks_name),
        os.path.join(ITEM_MODEL_DIR, f"{stairs_name}.json"): items.block(stairs_name),
        os.path.join(ITEM_MODEL_DIR, f"{slab_name}.json"): items.block(slab_name),
        os.path.join(ITEM_MODEL_DIR, f"{button_name}.json"): items.block_inventory(button_name),
        # loot tables
        os.path.join(LOOT_TABLE_DIR, f"{log_name}.json"): loottables.block_drops(log_name),
        os.path.join(LOOT_TABLE_DIR, f"{wood_name}.json"): loottables.block_drops(wood_name),
        os.path.join(LOOT_TABLE_DIR, f"{stripped_log_name}.json"): loottables.block_drops(stripped_log_name),
        os.path.join(LOOT_TABLE_DIR, f"{stripped_wood_name}.json"): loottables.block_drops(stripped_wood_name),
        os.path.join(LOOT_TABLE_DIR, f"{planks_name}.json"): loottables.block_drops(planks_name),
        os.path.join(LOOT_TABLE_DIR, f"{stairs_name}.json"): loottables.block_drops(stairs_name),
        os.path.join(LOOT_TABLE_DIR, f"{slab_name}.json"): loottables.block_drops(slab_name),
        os.path.join(LOOT_TABLE_DIR, f"{button_name}.json"): loottables.block_drops(button_name),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All wood block models + blockstate files generated successfully!")
