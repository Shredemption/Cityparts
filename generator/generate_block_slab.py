import os
import json

import blockstates, models, items

# === CONFIG ===
MOD_ID = "streetparts"
MATERIALS = [
    "asphalt",
    "red_asphalt",
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
        os.path.join(BLOCKSTATE_DIR, f"{slab_name}.json"): blockstates.slab(block_name),
        # block model
        os.path.join(BLOCK_MODEL_DIR, f"{block_name}.json"): models.block(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}.json"): models.slab(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}_top.json"): models.slab_top(block_name),
        # item models
        os.path.join(ITEM_MODEL_DIR, f"{block_name}.json"): items.block(block_name),
        os.path.join(ITEM_MODEL_DIR, f"{slab_name}.json"): items.block(slab_name),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All wall model + blockstate files generated successfully!")
