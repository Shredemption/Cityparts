import os
import json

import blockstates, models, items, loottables, recipes

# === CONFIG ===
MOD_ID = "cityparts"
COLORS = [
    "gray",
    "white",
    "black",
    "green",
]

TYPES_BASE = [
    "light",
    "post",
    "arm",
    "post_lamp",
]

SHAPES = {
    "corner": ["north"],
    "l_corner": ["north", "east"],
    "t_corner": ["north", "south"],
    "y_corner": ["north", "east", "west"],
    "x_corner": ["north", "east", "south", "west"],
}

BASE_PATH = r"./src/main/resources/"
BLOCKSTATE_DIR = os.path.join(BASE_PATH, f"assets/{MOD_ID}/blockstates")
BLOCK_MODEL_DIR = os.path.join(BASE_PATH, f"assets/{MOD_ID}/models/block")
ITEM_MODEL_DIR = os.path.join(BASE_PATH, f"assets/{MOD_ID}/models/item")
LOOT_TABLE_DIR = os.path.join(BASE_PATH, f"data/{MOD_ID}/loot_table/blocks")
RECIPE_DIR = os.path.join(BASE_PATH, f"data/{MOD_ID}/recipe")
TAG_DIR = os.path.join(BASE_PATH, f"data/{MOD_ID}/tags/block")

# === Ensure directories exist ===
for path in [BLOCKSTATE_DIR, BLOCK_MODEL_DIR, ITEM_MODEL_DIR, LOOT_TABLE_DIR, RECIPE_DIR, TAG_DIR]:
    os.makedirs(path, exist_ok=True)


# === Generate files ===
lights_tag = "lights"

for color in COLORS:

    # Multipart piece models
    files = {
        os.path.join(BLOCK_MODEL_DIR, f"light_{color}_half_post.json"): models.light_half_post(color),
        os.path.join(BLOCK_MODEL_DIR, f"light_{color}_corner_part.json"): models.light_corner_part(color),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

    # Base types: light, post, arm
    for type in TYPES_BASE:

        full_name = f"light_{color}_{type}"

        files = {
            os.path.join(BLOCKSTATE_DIR, f"{full_name}.json"): blockstates.light(color, type),
            os.path.join(BLOCK_MODEL_DIR, f"{full_name}.json"): models.light(color, type),
            os.path.join(ITEM_MODEL_DIR, f"{full_name}.json"): items.light(color, type),
            os.path.join(LOOT_TABLE_DIR, f"{full_name}.json"): loottables.block_drops(full_name),
            os.path.join(RECIPE_DIR, f"{full_name}.json"): recipes.one_from_tag_stonecutter(lights_tag, full_name),
        }

        for path, data in files.items():
            with open(path, "w", encoding="utf-8") as f:
                json.dump(data, f, indent=4)
            print(f"✅ Created {path}")

    # Multipart types
    for shape, directions in SHAPES.items():

        # Half-post version
        full_name = f"light_{color}_{shape}"

        files = {
            os.path.join(BLOCKSTATE_DIR, f"{full_name}.json"): blockstates.light_multipart(
                color,
                "half_post",
                directions,
            ),
            os.path.join(ITEM_MODEL_DIR, f"{full_name}.json"): items.light(color, shape),
            os.path.join(LOOT_TABLE_DIR, f"{full_name}.json"): loottables.block_drops(full_name),
            os.path.join(RECIPE_DIR, f"{full_name}.json"): recipes.one_from_tag_stonecutter(lights_tag, full_name),
        }

        # Full-post version
        full_name_post = f"light_{color}_{shape}_post"

        files.update(
            {
                os.path.join(BLOCKSTATE_DIR, f"{full_name_post}.json"): blockstates.light_multipart(
                    color,
                    "post",
                    directions,
                ),
                os.path.join(ITEM_MODEL_DIR, f"{full_name_post}.json"): items.light(color, shape + "_post"),
                os.path.join(LOOT_TABLE_DIR, f"{full_name_post}.json"): loottables.block_drops(full_name_post),
                os.path.join(RECIPE_DIR, f"{full_name_post}.json"): recipes.one_from_tag_stonecutter(
                    lights_tag, full_name_post
                ),
            }
        )

        for path, data in files.items():
            with open(path, "w", encoding="utf-8") as f:
                json.dump(data, f, indent=4)
            print(f"✅ Created {path}")


def create_tag(filename, values):
    path = os.path.join(TAG_DIR, filename)

    data = {"values": values}

    with open(path, "w", encoding="utf-8") as f:
        json.dump(data, f, indent=4)
        f.write("\n")

    print(f"✅ Created {path}")


lights_values = []

for type in TYPES_BASE:

    tag_name = f"light_{type}s.json"

    values = []

    for color in COLORS:
        values.append(f"{MOD_ID}:light_{color}_{type}")

    create_tag(tag_name, values)

    lights_values.append(f"#{MOD_ID}:light_{type}s")

for shape in SHAPES:

    tag_name = f"light_{shape}s.json"
    tag_name_post = f"light_{shape}_posts.json"

    values = []
    values_post = []

    for color in COLORS:
        values.append(f"{MOD_ID}:light_{color}_{shape}")

        values_post.append(f"{MOD_ID}:light_{color}_{shape}_post")

    create_tag(tag_name, values)
    create_tag(tag_name_post, values_post)

    lights_values.append(f"#{MOD_ID}:light_{shape}s")
    lights_values.append(f"#{MOD_ID}:light_{shape}_posts")

create_tag(
    "lights.json",
    lights_values,
)


print("\n✨ All lights model + blockstate files generated successfully!")
