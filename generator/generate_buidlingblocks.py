import os
import json

# === CONFIG ===
MOD_ID = "streetparts"
MATERIALS = [
    "stone_pavement",
    "andesite_pavement",
    "diorite_pavement",
    "granite_pavement",
    "deepslate_pavement",
    "sandstone_bricks",
    "brown_bricks",
    "maroon_bricks",
    "green_bricks",
    "blue_bricks",
    "white_bricks",
    "gray_bricks",
    "black_bricks",
    "beige_bricks",
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


def blockstate_wall_json(name):
    return {
        "multipart": [
            {
                "apply": {"model": f"{MOD_ID}:block/{name}_wall_post"},
                "when": {"up": "true"},
            },
            {
                "apply": {
                    "model": f"{MOD_ID}:block/{name}_wall_side",
                    "uvlock": "true",
                },
                "when": {"north": "low"},
            },
            {
                "apply": {
                    "model": f"{MOD_ID}:block/{name}_wall_side",
                    "uvlock": "true",
                    "y": 90,
                },
                "when": {"east": "low"},
            },
            {
                "apply": {
                    "model": f"{MOD_ID}:block/{name}_wall_side",
                    "uvlock": "true",
                    "y": 180,
                },
                "when": {"south": "low"},
            },
            {
                "apply": {
                    "model": f"{MOD_ID}:block/{name}_wall_side",
                    "uvlock": "true",
                    "y": 270,
                },
                "when": {"west": "low"},
            },
            {
                "apply": {
                    "model": f"{MOD_ID}:block/{name}_wall_side_tall",
                    "uvlock": "true",
                },
                "when": {"north": "tall"},
            },
            {
                "apply": {
                    "model": f"{MOD_ID}:block/{name}_wall_side_tall",
                    "uvlock": "true",
                    "y": 90,
                },
                "when": {"east": "tall"},
            },
            {
                "apply": {
                    "model": f"{MOD_ID}:block/{name}_wall_side_tall",
                    "uvlock": "true",
                    "y": 180,
                },
                "when": {"south": "tall"},
            },
            {
                "apply": {
                    "model": f"{MOD_ID}:block/{name}_wall_side_tall",
                    "uvlock": "true",
                    "y": 270,
                },
                "when": {"west": "tall"},
            },
        ]
    }


# item models
def item_block_model_json(name):
    return {"parent": f"{MOD_ID}:block/{name}"}


def item_stairs_model_json(name):
    return {"parent": f"{MOD_ID}:block/{name}_stairs"}


def item_slab_model_json(name):
    return {"parent": f"{MOD_ID}:block/{name}_slab"}


def item_wall_model_json(name):
    return {"parent": f"{MOD_ID}:block/{name}_wall_inventory"}


# block model
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


# wall models
def model_wall_post_json(name):
    return {
        "parent": "minecraft:block/template_wall_post",
        "textures": {"wall": f"{MOD_ID}:block/{name}"},
    }


def model_wall_side_json(name):
    return {
        "parent": "minecraft:block/template_wall_side",
        "textures": {"wall": f"{MOD_ID}:block/{name}"},
    }


def model_wall_side_tall_json(name):
    return {
        "parent": "minecraft:block/template_wall_side_tall",
        "textures": {"wall": f"{MOD_ID}:block/{name}"},
    }


def model_wall_inventory_json(name):
    return {
        "parent": "minecraft:block/wall_inventory",
        "textures": {"wall": f"{MOD_ID}:block/{name}"},
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
        os.path.join(BLOCKSTATE_DIR, f"{stairs_name}.json"): blockstate_stairs_json(mat),
        os.path.join(BLOCKSTATE_DIR, f"{slab_name}.json"): blockstate_slab_json(mat),
        os.path.join(BLOCKSTATE_DIR, f"{wall_name}.json"): blockstate_wall_json(mat),
        # item models
        os.path.join(ITEM_MODEL_DIR, f"{block_name}.json"): item_block_model_json(mat),
        os.path.join(ITEM_MODEL_DIR, f"{stairs_name}.json"): item_stairs_model_json(mat),
        os.path.join(ITEM_MODEL_DIR, f"{slab_name}.json"): item_slab_model_json(mat),
        os.path.join(ITEM_MODEL_DIR, f"{wall_name}.json"): item_wall_model_json(mat),
        # block model
        os.path.join(BLOCK_MODEL_DIR, f"{block_name}.json"): model_block_json(mat),
        # stairs models
        os.path.join(BLOCK_MODEL_DIR, f"{stairs_name}.json"): model_stairs_json(mat),
        os.path.join(BLOCK_MODEL_DIR, f"{stairs_name}_inner.json"): model_stairs_inner_json(mat),
        os.path.join(BLOCK_MODEL_DIR, f"{stairs_name}_outer.json"): model_stairs_outer_json(mat),
        # slab models
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}.json"): model_slab_json(mat),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}_top.json"): model_slab_top_json(mat),
        # wall models
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_post.json"): model_wall_post_json(mat),
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_side.json"): model_wall_side_json(mat),
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_side_tall.json"): model_wall_side_tall_json(mat),
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_inventory.json"): model_wall_inventory_json(mat),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All building block models + blockstate files generated successfully!")
