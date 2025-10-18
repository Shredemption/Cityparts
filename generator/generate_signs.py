import os
import json

import blockstates, models, items, loottables, recipes

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
for sign in ROUND:
    sign_name = f"sign_round_{sign}"
    signs_tag = "signs"

    files = {
        os.path.join(BLOCKSTATE_DIR, f"{sign_name}.json"): blockstates.horizontalRotating(sign_name),
        os.path.join(BLOCK_MODEL_DIR, f"{sign_name}.json"): models.sign_round(sign_name),
        os.path.join(ITEM_MODEL_DIR, f"{sign_name}.json"): items.block(sign_name),
        os.path.join(LOOT_TABLE_DIR, f"{sign_name}.json"): loottables.block_drops(sign_name),
        os.path.join(RECIPE_DIR, f"{sign_name}.json"): recipes.traffic_sign(sign_name),
        os.path.join(RECIPE_DIR, f"{sign_name}_from_sign.json"): recipes.one_from_tag_stonecutter(
            signs_tag, sign_name
        ),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

for sign in SQUARE:
    sign_name = f"sign_square_{sign}"

    files = {
        os.path.join(BLOCKSTATE_DIR, f"{sign_name}.json"): blockstates.horizontalRotating(sign_name),
        os.path.join(BLOCK_MODEL_DIR, f"{sign_name}.json"): models.sign_square(sign_name),
        os.path.join(ITEM_MODEL_DIR, f"{sign_name}.json"): items.block(sign_name),
        os.path.join(LOOT_TABLE_DIR, f"{sign_name}.json"): loottables.block_drops(sign_name),
        os.path.join(RECIPE_DIR, f"{sign_name}.json"): recipes.traffic_sign(sign_name),
        os.path.join(RECIPE_DIR, f"{sign_name}_from_sign.json"): recipes.one_from_tag_stonecutter(
            signs_tag, sign_name
        ),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

for sign in TRIANGLE:
    sign_name = f"sign_triangle_{sign}"

    files = {
        os.path.join(BLOCKSTATE_DIR, f"{sign_name}.json"): blockstates.horizontalRotating(sign_name),
        os.path.join(BLOCK_MODEL_DIR, f"{sign_name}.json"): models.sign_triangle(sign_name),
        os.path.join(ITEM_MODEL_DIR, f"{sign_name}.json"): items.block(sign_name),
        os.path.join(LOOT_TABLE_DIR, f"{sign_name}.json"): loottables.block_drops(sign_name),
        os.path.join(RECIPE_DIR, f"{sign_name}.json"): recipes.traffic_sign(sign_name),
        os.path.join(RECIPE_DIR, f"{sign_name}_from_sign.json"): recipes.one_from_tag_stonecutter(
            signs_tag, sign_name
        ),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All sign model + blockstate files generated successfully!")
