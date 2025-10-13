import os
import json

import blockstates

# === CONFIG ===
MOD_ID = "streetparts"

ROUND = [
    "stop",
    "no_entry",
    "roundabout",
    "left_pass",
    "left_right_pass",
    "right_pass",
    "arrow_left",
    "arrow_forward",
    "arrow_right",
    "arrow_forward_left",
    "arrow_left_right",
    "arrow_forward_right",
    "30",
    "45",
    "50",
    "60",
    "80",
    "90",
    "100",
    "120",
    "130",
    "oncoming_yield",
]

SQUARE = [
    "arrow_left",
    "arrow_forward",
    "arrow_right",
    "arrow_forward_left",
    "arrow_left_right",
    "arrow_forward_right",
    "oncoming_priority",
    "parking",
]

TRIANGLE = [
    "warning",
    "danger",
    "danger_cross",
    "crossing_left",
    "crossing_left_right",
    "crossing_right",
    "sharp_left",
    "sharp_right",
]

BASE_PATH = r"./src/main/resources/assets/" + MOD_ID
BLOCKSTATE_DIR = os.path.join(BASE_PATH, "blockstates")
BLOCK_MODEL_DIR = os.path.join(BASE_PATH, "models/block")
ITEM_MODEL_DIR = os.path.join(BASE_PATH, "models/item")

# === Ensure directories exist ===
for path in [BLOCKSTATE_DIR, BLOCK_MODEL_DIR, ITEM_MODEL_DIR]:
    os.makedirs(path, exist_ok=True)

# === JSON templates ===


def model_round_json(name):
    return {
        "parent": f"{MOD_ID}:block/template/sign_round",
        "textures": {"sign": f"{MOD_ID}:block/{name}"},
    }


def model_square_json(name):
    return {
        "parent": f"{MOD_ID}:block/template/sign_square",
        "textures": {"sign": f"{MOD_ID}:block/{name}"},
    }


def model_triangle_json(name):
    return {
        "parent": f"{MOD_ID}:block/template/sign_triangle",
        "textures": {"sign": f"{MOD_ID}:block/{name}"},
    }


def item_json(name):
    return {"parent": "item/generated", "textures": {"layer0": f"{MOD_ID}:block/{name}"}}


# === Generate files ===
for sign in ROUND:
    sign_name = f"sign_round_{sign}"

    files = {
        os.path.join(BLOCKSTATE_DIR, f"{sign_name}.json"): blockstates.horizontalRotating(sign_name),
        os.path.join(BLOCK_MODEL_DIR, f"{sign_name}.json"): model_round_json(sign_name),
        os.path.join(ITEM_MODEL_DIR, f"{sign_name}.json"): item_json(sign_name),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

for sign in SQUARE:
    sign_name = f"sign_square_{sign}"

    files = {
        os.path.join(BLOCKSTATE_DIR, f"{sign_name}.json"): blockstates.horizontalRotating(sign_name),
        os.path.join(BLOCK_MODEL_DIR, f"{sign_name}.json"): model_square_json(sign_name),
        os.path.join(ITEM_MODEL_DIR, f"{sign_name}.json"): item_json(sign_name),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

for sign in TRIANGLE:
    sign_name = f"sign_triangle_{sign}"

    files = {
        os.path.join(BLOCKSTATE_DIR, f"{sign_name}.json"): blockstates.horizontalRotating(sign_name),
        os.path.join(BLOCK_MODEL_DIR, f"{sign_name}.json"): model_triangle_json(sign_name),
        os.path.join(ITEM_MODEL_DIR, f"{sign_name}.json"): item_json(sign_name),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All sign model + blockstate files generated successfully!")
