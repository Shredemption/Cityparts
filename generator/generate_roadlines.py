import os
import json

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
                        "pedestrian_crossing"
]

BASE_PATH = r"./src/main/resources/assets/" + MOD_ID
BLOCKSTATE_DIR = os.path.join(BASE_PATH, "blockstates")
BLOCK_MODEL_DIR = os.path.join(BASE_PATH, "models/block/roadlines")
ITEM_MODEL_DIR = os.path.join(BASE_PATH, "models/item")

# === Ensure directories exist ===
for path in [BLOCKSTATE_DIR, BLOCK_MODEL_DIR, ITEM_MODEL_DIR]:
    os.makedirs(path, exist_ok=True)

# === JSON templates ===

def blockstate_json(name):
    return {
        "variants": {
            "facing=north": { "model": f"{MOD_ID}:block/roadlines/roadlines_{name}" },
            "facing=south": { "model": f"{MOD_ID}:block/roadlines/roadlines_{name}", "y": 180 },
            "facing=west":  { "model": f"{MOD_ID}:block/roadlines/roadlines_{name}", "y": 270 },
            "facing=east":  { "model": f"{MOD_ID}:block/roadlines/roadlines_{name}", "y": 90 }
        }
    }
    
def blockstate_slab_json(name):
    return {
        "variants": {
            "facing=north": { "model": f"{MOD_ID}:block/roadlines/roadlines_{name}_slab" },
            "facing=south": { "model": f"{MOD_ID}:block/roadlines/roadlines_{name}_slab", "y": 180 },
            "facing=west":  { "model": f"{MOD_ID}:block/roadlines/roadlines_{name}_slab", "y": 270 },
            "facing=east":  { "model": f"{MOD_ID}:block/roadlines/roadlines_{name}_slab", "y": 90 }
        }
    }

def block_model_json(name):
    return {
        "parent": f"{MOD_ID}:block/roadlines/roadlines",
        "textures": {
            "top": f"{MOD_ID}:blocks/roadlines_{name}"
        }
    }
    
def block_model_slab_json(name):
    return {
        "parent": f"{MOD_ID}:block/roadlines/roadlines_slab",
        "textures": {
            "top": f"{MOD_ID}:blocks/roadlines_{name}"
        }
    }

def item_model_json(name):
    return {
        "parent": f"{MOD_ID}:block/roadlines/roadlines_{name}"
    }
    
def item_model_slab_json(name):
    return {
        "parent": f"{MOD_ID}:block/roadlines/roadlines_{name}_slab"
    }

# === Generate files ===
for var in VARIANTS:
    roadline_name = f"roadlines_{var}"

    files = {
        os.path.join(BLOCKSTATE_DIR, f"{roadline_name}.json"): blockstate_json(var),
        os.path.join(BLOCK_MODEL_DIR, f"{roadline_name}.json"): block_model_json(var),
        os.path.join(ITEM_MODEL_DIR, f"{roadline_name}.json"): item_model_json(var),
        os.path.join(BLOCKSTATE_DIR, f"{roadline_name}_slab.json"): blockstate_slab_json(var),
        os.path.join(BLOCK_MODEL_DIR, f"{roadline_name}_slab.json"): block_model_slab_json(var),
        os.path.join(ITEM_MODEL_DIR, f"{roadline_name}_slab.json"): item_model_slab_json(var),
    }

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All roadlines model + blockstate files generated successfully!")
