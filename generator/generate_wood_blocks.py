import os
import json

# === CONFIG ===
MOD_ID = "streetparts"
VARIANTS = [
    "olive",
    "verdant",
    "moon",
    "sky",
    "wisteria",
    "ebony",
]

BASE_PATH = r"./src/main/resources/assets/" + MOD_ID
BLOCKSTATE_DIR = os.path.join(BASE_PATH, "blockstates")
BLOCK_MODEL_DIR = os.path.join(BASE_PATH, "models/block")
ITEM_MODEL_DIR = os.path.join(BASE_PATH, "models/item")

# === Ensure directories exist ===
for path in [BLOCKSTATE_DIR, BLOCK_MODEL_DIR, ITEM_MODEL_DIR]:
    os.makedirs(path, exist_ok=True)

# === JSON templates ===


# blockstates
def blockstate_pillar_json(name):
    return {
        "variants": {
            "axis=x": {"model": f"{MOD_ID}:block/{name}_horizontal", "x": 90, "y": 90},
            "axis=y": {"model": f"{MOD_ID}:block/{name}"},
            "axis=z": {"model": f"{MOD_ID}:block/{name}_horizontal", "x": 90},
        }
    }


def blockstate_block_json(name):
    return {"variants": {"": {"model": f"{MOD_ID}:block/{name}"}}}


def blockstate_stairs_json(name):
    return {
        "variants": {
            "facing=east,half=bottom,shape=inner_left": {
                "model": f"{MOD_ID}:block/{name}_stairs_inner",
                "uvlock": "true",
                "y": 270,
            },
            "facing=east,half=bottom,shape=inner_right": {"model": f"{MOD_ID}:block/{name}_stairs_inner"},
            "facing=east,half=bottom,shape=outer_left": {
                "model": f"{MOD_ID}:block/{name}_stairs_outer",
                "uvlock": "true",
                "y": 270,
            },
            "facing=east,half=bottom,shape=outer_right": {"model": f"{MOD_ID}:block/{name}_stairs_outer"},
            "facing=east,half=bottom,shape=straight": {"model": f"{MOD_ID}:block/{name}_stairs"},
            "facing=east,half=top,shape=inner_left": {
                "model": f"{MOD_ID}:block/{name}_stairs_inner",
                "uvlock": "true",
                "x": 180,
            },
            "facing=east,half=top,shape=inner_right": {
                "model": f"{MOD_ID}:block/{name}_stairs_inner",
                "uvlock": "true",
                "x": 180,
                "y": 90,
            },
            "facing=east,half=top,shape=outer_left": {
                "model": f"{MOD_ID}:block/{name}_stairs_outer",
                "uvlock": "true",
                "x": 180,
            },
            "facing=east,half=top,shape=outer_right": {
                "model": f"{MOD_ID}:block/{name}_stairs_outer",
                "uvlock": "true",
                "x": 180,
                "y": 90,
            },
            "facing=east,half=top,shape=straight": {
                "model": f"{MOD_ID}:block/{name}_stairs",
                "uvlock": "true",
                "x": 180,
            },
            "facing=north,half=bottom,shape=inner_left": {
                "model": f"{MOD_ID}:block/{name}_stairs_inner",
                "uvlock": "true",
                "y": 180,
            },
            "facing=north,half=bottom,shape=inner_right": {
                "model": f"{MOD_ID}:block/{name}_stairs_inner",
                "uvlock": "true",
                "y": 270,
            },
            "facing=north,half=bottom,shape=outer_left": {
                "model": f"{MOD_ID}:block/{name}_stairs_outer",
                "uvlock": "true",
                "y": 180,
            },
            "facing=north,half=bottom,shape=outer_right": {
                "model": f"{MOD_ID}:block/{name}_stairs_outer",
                "uvlock": "true",
                "y": 270,
            },
            "facing=north,half=bottom,shape=straight": {
                "model": f"{MOD_ID}:block/{name}_stairs",
                "uvlock": "true",
                "y": 270,
            },
            "facing=north,half=top,shape=inner_left": {
                "model": f"{MOD_ID}:block/{name}_stairs_inner",
                "uvlock": "true",
                "x": 180,
                "y": 270,
            },
            "facing=north,half=top,shape=inner_right": {
                "model": f"{MOD_ID}:block/{name}_stairs_inner",
                "uvlock": "true",
                "x": 180,
            },
            "facing=north,half=top,shape=outer_left": {
                "model": f"{MOD_ID}:block/{name}_stairs_outer",
                "uvlock": "true",
                "x": 180,
                "y": 270,
            },
            "facing=north,half=top,shape=outer_right": {
                "model": f"{MOD_ID}:block/{name}_stairs_outer",
                "uvlock": "true",
                "x": 180,
            },
            "facing=north,half=top,shape=straight": {
                "model": f"{MOD_ID}:block/{name}_stairs",
                "uvlock": "true",
                "x": 180,
                "y": 270,
            },
            "facing=south,half=bottom,shape=inner_left": {"model": f"{MOD_ID}:block/{name}_stairs_inner"},
            "facing=south,half=bottom,shape=inner_right": {
                "model": f"{MOD_ID}:block/{name}_stairs_inner",
                "uvlock": "true",
                "y": 90,
            },
            "facing=south,half=bottom,shape=outer_left": {"model": f"{MOD_ID}:block/{name}_stairs_outer"},
            "facing=south,half=bottom,shape=outer_right": {
                "model": f"{MOD_ID}:block/{name}_stairs_outer",
                "uvlock": "true",
                "y": 90,
            },
            "facing=south,half=bottom,shape=straight": {
                "model": f"{MOD_ID}:block/{name}_stairs",
                "uvlock": "true",
                "y": 90,
            },
            "facing=south,half=top,shape=inner_left": {
                "model": f"{MOD_ID}:block/{name}_stairs_inner",
                "uvlock": "true",
                "x": 180,
                "y": 90,
            },
            "facing=south,half=top,shape=inner_right": {
                "model": f"{MOD_ID}:block/{name}_stairs_inner",
                "uvlock": "true",
                "x": 180,
                "y": 180,
            },
            "facing=south,half=top,shape=outer_left": {
                "model": f"{MOD_ID}:block/{name}_stairs_outer",
                "uvlock": "true",
                "x": 180,
                "y": 90,
            },
            "facing=south,half=top,shape=outer_right": {
                "model": f"{MOD_ID}:block/{name}_stairs_outer",
                "uvlock": "true",
                "x": 180,
                "y": 180,
            },
            "facing=south,half=top,shape=straight": {
                "model": f"{MOD_ID}:block/{name}_stairs",
                "uvlock": "true",
                "x": 180,
                "y": 90,
            },
            "facing=west,half=bottom,shape=inner_left": {
                "model": f"{MOD_ID}:block/{name}_stairs_inner",
                "uvlock": "true",
                "y": 90,
            },
            "facing=west,half=bottom,shape=inner_right": {
                "model": f"{MOD_ID}:block/{name}_stairs_inner",
                "uvlock": "true",
                "y": 180,
            },
            "facing=west,half=bottom,shape=outer_left": {
                "model": f"{MOD_ID}:block/{name}_stairs_outer",
                "uvlock": "true",
                "y": 90,
            },
            "facing=west,half=bottom,shape=outer_right": {
                "model": f"{MOD_ID}:block/{name}_stairs_outer",
                "uvlock": "true",
                "y": 180,
            },
            "facing=west,half=bottom,shape=straight": {
                "model": f"{MOD_ID}:block/{name}_stairs",
                "uvlock": "true",
                "y": 180,
            },
            "facing=west,half=top,shape=inner_left": {
                "model": f"{MOD_ID}:block/{name}_stairs_inner",
                "uvlock": "true",
                "x": 180,
                "y": 180,
            },
            "facing=west,half=top,shape=inner_right": {
                "model": f"{MOD_ID}:block/{name}_stairs_inner",
                "uvlock": "true",
                "x": 180,
                "y": 270,
            },
            "facing=west,half=top,shape=outer_left": {
                "model": f"{MOD_ID}:block/{name}_stairs_outer",
                "uvlock": "true",
                "x": 180,
                "y": 180,
            },
            "facing=west,half=top,shape=outer_right": {
                "model": f"{MOD_ID}:block/{name}_stairs_outer",
                "uvlock": "true",
                "x": 180,
                "y": 270,
            },
            "facing=west,half=top,shape=straight": {
                "model": f"{MOD_ID}:block/{name}_stairs",
                "uvlock": "true",
                "x": 180,
                "y": 180,
            },
        }
    }


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


def item_stairs_model_json(name):
    return {"parent": f"{MOD_ID}:block/{name}_stairs"}


def item_slab_model_json(name):
    return {"parent": f"{MOD_ID}:block/{name}_slab"}


# block model
def model_pillar(name):
    return {
        "parent": "minecraft:block/cube_column",
        "textures": {"end": f"{MOD_ID}:block/{name}_top", "side": f"{MOD_ID}:block/{name}"},
    }


def model_pillar_horizontal(name):
    return {
        "parent": "minecraft:block/cube_column_horizontal",
        "textures": {"end": f"{MOD_ID}:block/{name}_top", "side": f"{MOD_ID}:block/{name}"},
    }


def model_block_json(name):
    return {"parent": "block/cube_all", "textures": {"all": f"{MOD_ID}:block/{name}"}}


# stairs models
def model_stairs_json(name):
    return {
        "parent": "block/stairs",
        "textures": {
            "bottom": f"{MOD_ID}:block/{name}",
            "top": f"{MOD_ID}:block/{name}",
            "side": f"{MOD_ID}:block/{name}",
        },
    }


def model_stairs_inner_json(name):
    return {
        "parent": "block/inner_stairs",
        "textures": {
            "bottom": f"{MOD_ID}:block/{name}",
            "top": f"{MOD_ID}:block/{name}",
            "side": f"{MOD_ID}:block/{name}",
        },
    }


def model_stairs_outer_json(name):
    return {
        "parent": "block/outer_stairs",
        "textures": {
            "bottom": f"{MOD_ID}:block/{name}",
            "top": f"{MOD_ID}:block/{name}",
            "side": f"{MOD_ID}:block/{name}",
        },
    }


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
for var in VARIANTS:
    log_name = f"{var}_log"
    wood_name = f"{var}_wood"
    stripped_log_name = f"stripped_{var}_log"
    stripped_wood_name = f"stripped_{var}_wood"
    planks_name = f"{var}_planks"
    stairs_name = f"{var}_stairs"
    slab_name = f"{var}_slab"

    files = {
        # blockstates
        os.path.join(BLOCKSTATE_DIR, f"{log_name}.json"): blockstate_pillar_json(log_name),
        os.path.join(BLOCKSTATE_DIR, f"{wood_name}.json"): blockstate_pillar_json(wood_name),
        os.path.join(BLOCKSTATE_DIR, f"{stripped_log_name}.json"): blockstate_pillar_json(stripped_log_name),
        os.path.join(BLOCKSTATE_DIR, f"{stripped_wood_name}.json"): blockstate_pillar_json(stripped_wood_name),
        os.path.join(BLOCKSTATE_DIR, f"{planks_name}.json"): blockstate_block_json(planks_name),
        os.path.join(BLOCKSTATE_DIR, f"{stairs_name}.json"): blockstate_stairs_json(var),
        os.path.join(BLOCKSTATE_DIR, f"{slab_name}.json"): blockstate_slab_json(var),
        # item models
        os.path.join(ITEM_MODEL_DIR, f"{log_name}.json"): item_block_model_json(log_name),
        os.path.join(ITEM_MODEL_DIR, f"{wood_name}.json"): item_block_model_json(wood_name),
        os.path.join(ITEM_MODEL_DIR, f"{stripped_log_name}.json"): item_block_model_json(stripped_log_name),
        os.path.join(ITEM_MODEL_DIR, f"{stripped_wood_name}.json"): item_block_model_json(stripped_wood_name),
        os.path.join(ITEM_MODEL_DIR, f"{planks_name}.json"): item_block_model_json(planks_name),
        os.path.join(ITEM_MODEL_DIR, f"{stairs_name}.json"): item_stairs_model_json(var),
        os.path.join(ITEM_MODEL_DIR, f"{slab_name}.json"): item_slab_model_json(var),
        # block model
        os.path.join(BLOCK_MODEL_DIR, f"{log_name}.json"): model_pillar(log_name),
        os.path.join(BLOCK_MODEL_DIR, f"{log_name}_horizontal.json"): model_pillar_horizontal(log_name),
        os.path.join(BLOCK_MODEL_DIR, f"{wood_name}.json"): model_pillar(wood_name),
        os.path.join(BLOCK_MODEL_DIR, f"{wood_name}_horizontal.json"): model_pillar_horizontal(wood_name),
        os.path.join(BLOCK_MODEL_DIR, f"{stripped_log_name}.json"): model_pillar(stripped_log_name),
        os.path.join(BLOCK_MODEL_DIR, f"{stripped_log_name}_horizontal.json"): model_pillar_horizontal(
            stripped_log_name
        ),
        os.path.join(BLOCK_MODEL_DIR, f"{stripped_wood_name}.json"): model_pillar(stripped_wood_name),
        os.path.join(BLOCK_MODEL_DIR, f"{stripped_wood_name}_horizontal.json"): model_pillar_horizontal(
            stripped_wood_name
        ),
        os.path.join(BLOCK_MODEL_DIR, f"{planks_name}.json"): model_block_json(planks_name),
        # stairs models
        os.path.join(BLOCK_MODEL_DIR, f"{stairs_name}.json"): model_stairs_json(var),
        os.path.join(BLOCK_MODEL_DIR, f"{stairs_name}_inner.json"): model_stairs_inner_json(var),
        os.path.join(BLOCK_MODEL_DIR, f"{stairs_name}_outer.json"): model_stairs_outer_json(var),
        # slab models
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}.json"): model_slab_json(var),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}_top.json"): model_slab_top_json(var),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All wood block models + blockstate files generated successfully!")
