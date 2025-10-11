import os
import json

# === CONFIG ===
MOD_ID = "streetparts"
MATERIALS = [
    "stone_pavement",
    "andesite_pavement",
    "diorite_pavement",
    "granite_pavement",
    "gray_bricks",
    "brown_bricks",
    "sandstone_bricks"
]

BASE_PATH = r"./src/main/resources/assets/" + MOD_ID
BLOCKSTATE_DIR = os.path.join(BASE_PATH, "blockstates")
BLOCK_MODEL_DIR = os.path.join(BASE_PATH, "models/block/blocks")
ITEM_MODEL_DIR = os.path.join(BASE_PATH, "models/item")

# === Ensure directories exist ===
for path in [BLOCKSTATE_DIR, BLOCK_MODEL_DIR, ITEM_MODEL_DIR]:
    os.makedirs(path, exist_ok=True)

# === JSON templates ===

def blockstate_json(name):
    return {
        "multipart": [
            {
                "apply": {"model": f"{MOD_ID}:block/blocks/{name}_wall_post"},
                "when": {"up": "true"}
            },
            {
                "apply": {"model": f"{MOD_ID}:block/blocks/{name}_wall_side", "uvlock": True},
                "when": {"north": "low"}
            },
            {
                "apply": {"model": f"{MOD_ID}:block/blocks/{name}_wall_side", "uvlock": True, "y": 90},
                "when": {"east": "low"}
            },
            {
                "apply": {"model": f"{MOD_ID}:block/blocks/{name}_wall_side", "uvlock": True, "y": 180},
                "when": {"south": "low"}
            },
            {
                "apply": {"model": f"{MOD_ID}:block/blocks/{name}_wall_side", "uvlock": True, "y": 270},
                "when": {"west": "low"}
            },
            {
                "apply": {"model": f"{MOD_ID}:block/blocks/{name}_wall_side_tall", "uvlock": True},
                "when": {"north": "tall"}
            },
            {
                "apply": {"model": f"{MOD_ID}:block/blocks/{name}_wall_side_tall", "uvlock": True, "y": 90},
                "when": {"east": "tall"}
            },
            {
                "apply": {"model": f"{MOD_ID}:block/blocks/{name}_wall_side_tall", "uvlock": True, "y": 180},
                "when": {"south": "tall"}
            },
            {
                "apply": {"model": f"{MOD_ID}:block/blocks/{name}_wall_side_tall", "uvlock": True, "y": 270},
                "when": {"west": "tall"}
            }
        ]
    }

def model_post_json(name):
    return {
        "parent": "minecraft:block/template_wall_post",
        "textures": { "wall": f"{MOD_ID}:blocks/{name}" }
    }

def model_side_json(name):
    return {
        "parent": "minecraft:block/template_wall_side",
        "textures": { "wall": f"{MOD_ID}:blocks/{name}" }
    }

def model_side_tall_json(name):
    return {
        "parent": "minecraft:block/template_wall_side_tall",
        "textures": { "wall": f"{MOD_ID}:blocks/{name}" }
    }

def item_model_json(name):
    return {
        "parent": f"{MOD_ID}:block/blocks/{name}_wall_inventory"
    }

def model_inventory_json(name):
    return {
        "parent": "minecraft:block/wall_inventory",
        "textures": { "wall": f"{MOD_ID}:blocks/{name}" }
    }

# === Generate files ===
for mat in MATERIALS:
    wall_name = f"{mat}_wall"

    files = {
        os.path.join(BLOCKSTATE_DIR, f"{wall_name}.json"): blockstate_json(mat),
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_post.json"): model_post_json(mat),
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_side.json"): model_side_json(mat),
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_side_tall.json"): model_side_tall_json(mat),
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_inventory.json"): model_inventory_json(mat),
        os.path.join(ITEM_MODEL_DIR, f"{wall_name}.json"): item_model_json(mat),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All wall model + blockstate files generated successfully!")
