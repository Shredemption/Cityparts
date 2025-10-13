import os
import json

import blockstates, items

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

BASE_PATH = r"./src/main/resources/assets/" + MOD_ID
BLOCKSTATE_DIR = os.path.join(BASE_PATH, "blockstates")
BLOCK_MODEL_DIR = os.path.join(BASE_PATH, "models/block")
ITEM_MODEL_DIR = os.path.join(BASE_PATH, "models/item")

# === Ensure directories exist ===
for path in [BLOCKSTATE_DIR, BLOCK_MODEL_DIR, ITEM_MODEL_DIR]:
    os.makedirs(path, exist_ok=True)

# === JSON templates ===


def blockmodel(color, type):
    return {
        "parent": f"{MOD_ID}:block/template/light_{type}",
        "textures": {"0": f"{MOD_ID}:block/{color}_post"},
    }


# === Generate files ===
for color in COLORS:
    for type in TYPES:
        fullName = f"light_{color}_{type}"

        files = {
            os.path.join(BLOCKSTATE_DIR, f"{fullName}.json"): blockstates.light(color, type),
            os.path.join(BLOCK_MODEL_DIR, f"{fullName}.json"): blockmodel(color, type),
            os.path.join(ITEM_MODEL_DIR, f"{fullName}.json"): items.light(color, type),
        }

        for path, data in files.items():
            with open(path, "w", encoding="utf-8") as f:
                json.dump(data, f, indent=4)
            print(f"✅ Created {path}")

print("\n✨ All lights model + blockstate files generated successfully!")
