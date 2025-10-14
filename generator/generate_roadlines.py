import os
import json

import blockstates, models, items

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
]

BASE_PATH = r"./src/main/resources/assets/" + MOD_ID
BLOCKSTATE_DIR = os.path.join(BASE_PATH, "blockstates")
BLOCK_MODEL_DIR = os.path.join(BASE_PATH, "models/block")
ITEM_MODEL_DIR = os.path.join(BASE_PATH, "models/item")

# === Ensure directories exist ===
for path in [BLOCKSTATE_DIR, BLOCK_MODEL_DIR, ITEM_MODEL_DIR]:
    os.makedirs(path, exist_ok=True)


# === Generate files ===
for var in VARIANTS:
    block_name = f"roadlines_{var}"
    slab_name = f"roadlines_{var}_slab"

    files = {
        os.path.join(BLOCKSTATE_DIR, f"{block_name}.json"): blockstates.horizontalRotating(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{block_name}.json"): models.road_block(block_name),
        os.path.join(ITEM_MODEL_DIR, f"{block_name}.json"): items.block(block_name),
        os.path.join(BLOCKSTATE_DIR, f"{slab_name}.json"): blockstates.horizontalRotating(slab_name),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}.json"): models.road_slab(block_name),
        os.path.join(ITEM_MODEL_DIR, f"{slab_name}.json"): items.block(slab_name),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All roadlines model + blockstate files generated successfully!")
