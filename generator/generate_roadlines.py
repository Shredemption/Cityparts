import os
import json

import blockstates, models, items, loottables, recipes

# === CONFIG ===
MOD_ID = "streetparts"
VARIANTS = [
    "midline",
    "sideline",
    "halfline",
    "innercorner",
    "middlecorner",
    "outercorner",
    "cross",
    "cornercross",
    "tsplitshort",
    "tsplitmid",
    "tsplittall",
    "jcorner",
    "lcorner",
    "straightarrow",
    "leftarrow",
    "rightarrow",
    "leftrightarrow",
    "leftsubarrow",
    "rightsubarrow",
    "leftrightsubarrow",
    "shortleftt",
    "shortrightt",
    "middleleftt",
    "middlerightt",
    "tallleftt",
    "tallrightt",
    "sharktooth",
    "pedestrian_crossing",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "g",
    "h",
    "i",
    "j",
    "k",
    "l",
    "m",
    "n",
    "o",
    "p",
    "q",
    "r",
    "s",
    "t",
    "u",
    "v",
    "w",
    "x",
    "y",
    "z",
    "ij",
    "1",
    "2",
    "3",
    "4",
    "5",
    "6",
    "7",
    "8",
    "9",
    "0",
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
    block_name = f"roadlines_{var}"
    slab_name = f"roadlines_{var}_slab"

    block_tag = "roadlines"
    slab_tab = "roadlines_slab"

    files = {
        # blockstate
        os.path.join(BLOCKSTATE_DIR, f"{block_name}.json"): blockstates.horizontalRotating(block_name),
        os.path.join(BLOCKSTATE_DIR, f"{slab_name}.json"): blockstates.horizontalRotating(slab_name),
        # model
        os.path.join(BLOCK_MODEL_DIR, f"{block_name}.json"): models.road_block(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}.json"): models.road_slab(block_name),
        # item
        os.path.join(ITEM_MODEL_DIR, f"{block_name}.json"): items.block(block_name),
        os.path.join(ITEM_MODEL_DIR, f"{slab_name}.json"): items.block(slab_name),
        # loottable
        os.path.join(LOOT_TABLE_DIR, f"{block_name}.json"): loottables.block_drops(block_name),
        os.path.join(LOOT_TABLE_DIR, f"{slab_name}.json"): loottables.block_drops(slab_name),
        # recipes
        os.path.join(RECIPE_DIR, f"{block_name}.json"): recipes.one_from_tag_stonecutter(block_tag, block_name),
        os.path.join(RECIPE_DIR, f"{slab_name}.json"): recipes.one_from_tag_stonecutter(slab_tab, slab_name),
        os.path.join(RECIPE_DIR, f"{slab_name}_from_block.json"): recipes.two_from_tag_stonecutter(
            block_tag, slab_name
        ),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All roadlines model + blockstate files generated successfully!")
