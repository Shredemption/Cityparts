import os
import json

import blockstates, models, items, loottables, recipes

# === CONFIG ===
MOD_ID = "streetparts"
pavements = {
    "stone_pavement": "minecraft:stone",
    "andesite_pavement": "minecraft:andesite",
    "diorite_pavement": "minecraft:diorite",
    "granite_pavement": "minecraft:granite",
    "deepslate_pavement": "minecraft:deepslate",
}

bricks = {
    "sandstone_bricks": "minecraft:sand",
    "brown_bricks": "minecraft:brown_dye",
    "maroon_bricks": "minecraft:red_dye",
    "green_bricks": "minecraft:green_dye",
    "blue_bricks": "minecraft:blue_dye",
    "white_bricks": "minecraft:white_dye",
    "gray_bricks": "minecraft:gray_dye",
    "black_bricks": "minecraft:black_dye",
    "beige_bricks": "minecraft:yellow_dye",
}

materials = list(pavements.keys()) + list(bricks.keys())

BASE_PATH = r"./src/main/resources/"
BLOCKSTATE_DIR = os.path.join(BASE_PATH, f"assets/{MOD_ID}/blockstates")
BLOCK_MODEL_DIR = os.path.join(BASE_PATH, f"assets/{MOD_ID}/models/block")
ITEM_MODEL_DIR = os.path.join(BASE_PATH, f"assets/{MOD_ID}/models/item")
LOOT_TABLE_DIR = os.path.join(BASE_PATH, f"data/{MOD_ID}/loot_table/blocks")
RECIPE_DIR = os.path.join(BASE_PATH, f"data/{MOD_ID}/recipe")

# === Ensure directories exist ===
for path in [BLOCKSTATE_DIR, BLOCK_MODEL_DIR, ITEM_MODEL_DIR, LOOT_TABLE_DIR]:
    os.makedirs(path, exist_ok=True)


# === Generate files ===
for mat in materials:
    block_name = mat
    stairs_name = f"{mat}_stairs"
    slab_name = f"{mat}_slab"
    wall_name = f"{mat}_wall"

    files = {
        # blockstates
        os.path.join(BLOCKSTATE_DIR, f"{block_name}.json"): blockstates.block(block_name),
        os.path.join(BLOCKSTATE_DIR, f"{stairs_name}.json"): blockstates.stairs(block_name),
        os.path.join(BLOCKSTATE_DIR, f"{slab_name}.json"): blockstates.slab(block_name),
        os.path.join(BLOCKSTATE_DIR, f"{wall_name}.json"): blockstates.wall(block_name),
        # block model
        os.path.join(BLOCK_MODEL_DIR, f"{block_name}.json"): models.block(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{stairs_name}.json"): models.stairs(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{stairs_name}_inner.json"): models.stairs_inner(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{stairs_name}_outer.json"): models.stairs_outer(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}.json"): models.slab(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{slab_name}_top.json"): models.slab_top(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_post.json"): models.wall_post(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_side.json"): models.wall_side(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_side_tall.json"): models.wall_side_tall(block_name),
        os.path.join(BLOCK_MODEL_DIR, f"{wall_name}_inventory.json"): models.wall_inventory(block_name),
        # item models
        os.path.join(ITEM_MODEL_DIR, f"{block_name}.json"): items.block(block_name),
        os.path.join(ITEM_MODEL_DIR, f"{stairs_name}.json"): items.block(stairs_name),
        os.path.join(ITEM_MODEL_DIR, f"{slab_name}.json"): items.block(slab_name),
        os.path.join(ITEM_MODEL_DIR, f"{wall_name}.json"): items.block_inventory(wall_name),
        # loottables
        os.path.join(LOOT_TABLE_DIR, f"{block_name}.json"): loottables.block_drops(block_name),
        os.path.join(LOOT_TABLE_DIR, f"{stairs_name}.json"): loottables.block_drops(stairs_name),
        os.path.join(LOOT_TABLE_DIR, f"{slab_name}.json"): loottables.block_drops(slab_name),
        os.path.join(LOOT_TABLE_DIR, f"{wall_name}.json"): loottables.block_drops(wall_name),
        # recipes
        os.path.join(RECIPE_DIR, f"{stairs_name}.json"): recipes.building_stairs(block_name, stairs_name),
        os.path.join(RECIPE_DIR, f"{stairs_name}_stonecutter.json"): recipes.building_stairs_stonecutter(
            block_name, stairs_name
        ),
        os.path.join(RECIPE_DIR, f"{slab_name}.json"): recipes.building_slab(block_name, slab_name),
        os.path.join(RECIPE_DIR, f"{slab_name}_stonecutter.json"): recipes.building_slab_stonecutter(
            block_name, slab_name
        ),
        os.path.join(RECIPE_DIR, f"{wall_name}.json"): recipes.building_wall(block_name, wall_name),
        os.path.join(RECIPE_DIR, f"{wall_name}_stonecutter.json"): recipes.building_wall_stonecutter(
            block_name, wall_name
        ),
    }

    if block_name in pavements:
        files.update(
            {
                os.path.join(RECIPE_DIR, f"{block_name}.json"): recipes.pavement(pavements[block_name], block_name),
            }
        )
    else:
        files.update(
            {
                os.path.join(RECIPE_DIR, f"{block_name}.json"): recipes.brick_variant(bricks[block_name], block_name),
            }
        )

    for path, data in files.items():
        with open(path, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"✅ Created {path}")

print("\n✨ All building block models + blockstate files generated successfully!")
