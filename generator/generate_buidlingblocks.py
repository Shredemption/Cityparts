import os
import json

import blockstates, models, items

# === CONFIG ===
MOD_ID = "streetparts"
MATERIALS = [
    "stone_pavement",
    "andesite_pavement",
    "diorite_pavement",
    "granite_pavement",
    "deepslate_pavement",
    "sandstone_bricks",
    "brown_bricks",
    "maroon_bricks",
    "green_bricks",
    "blue_bricks",
    "white_bricks",
    "gray_bricks",
    "black_bricks",
    "beige_bricks",
]

BASE_PATH = r"./src/main/resources/assets/" + MOD_ID
BLOCKSTATE_DIR = os.path.join(BASE_PATH, "blockstates")
BLOCK_MODEL_DIR = os.path.join(BASE_PATH, "models/block")
ITEM_MODEL_DIR = os.path.join(BASE_PATH, "models/item")

# === Ensure directories exist ===
for path in [BLOCKSTATE_DIR, BLOCK_MODEL_DIR, ITEM_MODEL_DIR]:
    os.makedirs(path, exist_ok=True)


# === Generate files ===
for mat in MATERIALS:
    block_name = mat
    stairs_name = f"{mat}_stairs"
    slab_name = f"{mat}_slab"
    wall_name = f"{mat}_wall"

    files = {
        # blockstates
        os.path.join(BLOCKSTATE_DIR, f"{block_name}.json"): blockstates.block(block_name),
        os.path.join(BLOCKSTATE_DIR, f"{stairs_name}.json"): blockstates.stairs(block_name),
        os.path.join(BLOCKSTATE_DIR, f"{slab_name}.json"): blockstates.slab(block_name),
        os.path.join(BLOCKSTATE_DIR, f"{wall_name}.json"): blockstates.wall(block_name),
        # block model
        os.path.join(BLOCK_MODEL_DIR, f"{block_name}.json"): models.block(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{stairs_name}.json"): models.stairs(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{stairs_name}_inner.json"): models.stairs_inner(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{stairs_name}_outer.json"): models.stairs_outer(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}.json"): models.slab(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}_top.json"): models.slab_top(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_post.json"): models.wall_post(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_side.json"): models.wall_side(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_side_tall.json"): models.wall_side_tall(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_inventory.json"): models.wall_inventory(block_name),
        # item models
        os.path.join(ITEM_MODEL_DIR, f"{block_name}.json"): items.block(block_name),
        os.path.join(ITEM_MODEL_DIR, f"{stairs_name}.json"): items.block(stairs_name),
        os.path.join(ITEM_MODEL_DIR, f"{slab_name}.json"): items.block(slab_name),
        os.path.join(ITEM_MODEL_DIR, f"{wall_name}.json"): items.wall(wall_name),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All building block models + blockstate files generated successfully!")
