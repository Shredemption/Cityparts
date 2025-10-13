import os
import json

import blockstates

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

# === JSON templates ===


def block_model_json(name):
    return {
        "parent": f"{MOD_ID}:block/template/roadlines",
        "textures": {"top": f"{MOD_ID}:block/roadlines_{name}"},
    }


def block_model_slab_json(name):
    return {
        "parent": f"{MOD_ID}:block/template/roadlines_slab",
        "textures": {"top": f"{MOD_ID}:block/roadlines_{name}"},
    }


def item_model_json(name):
    return {"parent": f"{MOD_ID}:block/roadlines_{name}"}


def item_model_slab_json(name):
    return {"parent": f"{MOD_ID}:block/roadlines_{name}_slab"}


# === Generate files ===
for var in VARIANTS:
    block_name = f"roadlines_{var}"
    slab_name = f"roadlines_{var}_slab"

    files = {
        os.path.join(BLOCKSTATE_DIR, f"{block_name}.json"): blockstates.horizontalRotating(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{block_name}.json"): block_model_json(var),
        os.path.join(ITEM_MODEL_DIR, f"{block_name}.json"): item_model_json(var),
        os.path.join(BLOCKSTATE_DIR, f"{slab_name}.json"): blockstates.horizontalRotating(slab_name),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}.json"): block_model_slab_json(var),
        os.path.join(ITEM_MODEL_DIR, f"{slab_name}.json"): item_model_slab_json(var),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All roadlines model + blockstate files generated successfully!")
