import os
import json

import blockstates, models, items, loottables, recipes

# === CONFIG ===
MOD_ID = "cityparts"
MATERIALS = [
    "asphalt",
    "red_asphalt",
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
for mat in MATERIALS:
    block_name = mat
    slab_name = f"{mat}_slab"

    files = {
        # blockstates
        os.path.join(BLOCKSTATE_DIR, f"{block_name}.json"): blockstates.block(block_name),
        os.path.join(BLOCKSTATE_DIR, f"{slab_name}.json"): blockstates.slab(block_name),
        # block model
        os.path.join(BLOCK_MODEL_DIR, f"{block_name}.json"): models.block(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}.json"): models.slab(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}_top.json"): models.slab_top(block_name),
        # item models
        os.path.join(ITEM_MODEL_DIR, f"{block_name}.json"): items.block(block_name),
        os.path.join(ITEM_MODEL_DIR, f"{slab_name}.json"): items.block(slab_name),
        # loottables
        os.path.join(LOOT_TABLE_DIR, f"{block_name}.json"): loottables.block_drops(block_name),
        os.path.join(LOOT_TABLE_DIR, f"{slab_name}.json"): loottables.block_drops(slab_name),
        # recipes
        os.path.join(RECIPE_DIR, f"{slab_name}.json"): recipes.building_slab(block_name, slab_name),
        os.path.join(RECIPE_DIR, f"{slab_name}_stonecutter.json"): recipes.building_slab_stonecutter(
            block_name, slab_name
        ),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All wall model + blockstate files generated successfully!")
