import os
import json

# === CONFIG ===
MOD_ID = "streetparts"
MATERIALS = ["asphalt", "red_asphalt"]

BASE_PATH = r"./src/main/resources/assets/" + MOD_ID
BLOCKSTATE_DIR = os.path.join(BASE_PATH, "blockstates")
BLOCK_MODEL_DIR = os.path.join(BASE_PATH, "models/block")
ITEM_MODEL_DIR = os.path.join(BASE_PATH, "models/item")

# === Ensure directories exist ===
for path in [BLOCKSTATE_DIR, BLOCK_MODEL_DIR, ITEM_MODEL_DIR]:
    os.makedirs(path, exist_ok=True)

# === JSON templates ===


# blockstates
def blockstate_block_json(name):
    return {"variants": {"": {"model": f"{MOD_ID}:block/{name}"}}}


def blockstate_slab_json(name):
    return {
        "variants": {
            "type=bottom": {"model": f"{MOD_ID}:block/{name}_slab"},
            "type=top": {"model": f"{MOD_ID}:block/{name}_slab_top"},
            "type=double": {"model": f"{MOD_ID}:block/{name}"},
        }
    }


# item models
def item_block_model_json(name):
    return {"parent": f"{MOD_ID}:block/{name}"}


def item_slab_model_json(name):
    return {"parent": f"{MOD_ID}:block/{name}_slab"}


# block model
def model_block_json(name):
    return {"parent": "block/cube_all", "textures": {"all": f"{MOD_ID}:block/{name}"}}


# slab models
def model_slab_json(name):
    return {
        "parent": "block/slab",
        "textures": {
            "bottom": f"{MOD_ID}:block/{name}",
            "top": f"{MOD_ID}:block/{name}",
            "side": f"{MOD_ID}:block/{name}",
        },
    }


def model_slab_top_json(name):
    return {
        "parent": "block/slab_top",
        "textures": {
            "bottom": f"{MOD_ID}:block/{name}",
            "top": f"{MOD_ID}:block/{name}",
            "side": f"{MOD_ID}:block/{name}",
        },
    }


# === Generate files ===
for mat in MATERIALS:
    block_name = mat
    stairs_name = f"{mat}_stairs"
    slab_name = f"{mat}_slab"
    wall_name = f"{mat}_wall"

    files = {
        # blockstates
        os.path.join(BLOCKSTATE_DIR, f"{block_name}.json"): blockstate_block_json(mat),
        os.path.join(BLOCKSTATE_DIR, f"{slab_name}.json"): blockstate_slab_json(mat),
        # item models
        os.path.join(ITEM_MODEL_DIR, f"{block_name}.json"): item_block_model_json(mat),
        os.path.join(ITEM_MODEL_DIR, f"{slab_name}.json"): item_slab_model_json(mat),
        # block model
        os.path.join(BLOCK_MODEL_DIR, f"{block_name}.json"): model_block_json(mat),
        # slab models
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}.json"): model_slab_json(mat),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}_top.json"): model_slab_top_json(mat),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All wall model + blockstate files generated successfully!")
