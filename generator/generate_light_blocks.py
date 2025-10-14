import os
import json

import blockstates, models, items, loottables, recipes

# === CONFIG ===
MOD_ID = "streetparts"
COLORS = [
    "gray",
    "white",
    "black",
    "green",
]
TYPES = [
    "light",
    "post",
    "arm",
    "corner",
    "l_corner",
    "t_corner",
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
for color in COLORS:
    for type in TYPES:
        fullName = f"light_{color}_{type}"
        lights_tag = "lights"

        files = {
            os.path.join(BLOCKSTATE_DIR, f"{fullName}.json"): blockstates.light(color, type),
            os.path.join(BLOCK_MODEL_DIR, f"{fullName}.json"): models.light(color, type),
            os.path.join(ITEM_MODEL_DIR, f"{fullName}.json"): items.light(color, type),
            os.path.join(LOOT_TABLE_DIR, f"{fullName}.json"): loottables.block_drops(fullName),
            os.path.join(RECIPE_DIR, f"{fullName}.json"): recipes.one_from_tag_stonecutter(lights_tag, fullName),
        }

        for path, data in files.items():
            with open(path, "w", encoding="utf-8") as f:
                json.dump(data, f, indent=4)
            print(f"✅ Created {path}")

print("\n✨ All lights model + blockstate files generated successfully!")
