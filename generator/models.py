MOD_ID = "streetparts"


def block(name):
    return {"parent": "block/cube_all", "textures": {"all": f"{MOD_ID}:block/{name}"}}


def stairs(name):
    return {
        "parent": "block/stairs",
        "textures": {
            "bottom": f"{MOD_ID}:block/{name}",
            "top": f"{MOD_ID}:block/{name}",
            "side": f"{MOD_ID}:block/{name}",
        },
    }


def stairs_inner(name):
    return {
        "parent": "block/inner_stairs",
        "textures": {
            "bottom": f"{MOD_ID}:block/{name}",
            "top": f"{MOD_ID}:block/{name}",
            "side": f"{MOD_ID}:block/{name}",
        },
    }


def stairs_outer(name):
    return {
        "parent": "block/outer_stairs",
        "textures": {
            "bottom": f"{MOD_ID}:block/{name}",
            "top": f"{MOD_ID}:block/{name}",
            "side": f"{MOD_ID}:block/{name}",
        },
    }


def slab(name):
    return {
        "parent": "block/slab",
        "textures": {
            "bottom": f"{MOD_ID}:block/{name}",
            "top": f"{MOD_ID}:block/{name}",
            "side": f"{MOD_ID}:block/{name}",
        },
    }


def slab_top(name):
    return {
        "parent": "block/slab_top",
        "textures": {
            "bottom": f"{MOD_ID}:block/{name}",
            "top": f"{MOD_ID}:block/{name}",
            "side": f"{MOD_ID}:block/{name}",
        },
    }


def wall_post(name):
    return {
        "parent": "minecraft:block/template_wall_post",
        "textures": {"wall": f"{MOD_ID}:block/{name}"},
    }


def wall_side(name):
    return {
        "parent": "minecraft:block/template_wall_side",
        "textures": {"wall": f"{MOD_ID}:block/{name}"},
    }


def wall_side_tall(name):
    return {
        "parent": "minecraft:block/template_wall_side_tall",
        "textures": {"wall": f"{MOD_ID}:block/{name}"},
    }


def wall_inventory(name):
    return {
        "parent": "minecraft:block/wall_inventory",
        "textures": {"wall": f"{MOD_ID}:block/{name}"},
    }


def pillar(name):
    return {
        "parent": "minecraft:block/cube_column",
        "textures": {"end": f"{MOD_ID}:block/{name}_top", "side": f"{MOD_ID}:block/{name}"},
    }

def pillar_one_texture(name):
    return {
        "parent": "minecraft:block/cube_column",
        "textures": {"end": f"{MOD_ID}:block/{name}", "side": f"{MOD_ID}:block/{name}"},
    }


def pillar_horizontal(name):
    return {
        "parent": "minecraft:block/cube_column_horizontal",
        "textures": {"end": f"{MOD_ID}:block/{name}_top", "side": f"{MOD_ID}:block/{name}"},
    }
    
def pillar_horizontal_one_texture(name):
    return {
        "parent": "minecraft:block/cube_column_horizontal",
        "textures": {"end": f"{MOD_ID}:block/{name}", "side": f"{MOD_ID}:block/{name}"},
    }


def light(color, type):
    return {
        "parent": f"{MOD_ID}:block/template/light_{type}",
        "textures": {"0": f"{MOD_ID}:block/{color}_post"},
    }


def road_block(name):
    return {
        "parent": f"{MOD_ID}:block/template/roadlines",
        "textures": {"top": f"{MOD_ID}:block/{name}"},
    }


def road_slab(name):
    return {
        "parent": f"{MOD_ID}:block/template/roadlines_slab",
        "textures": {"top": f"{MOD_ID}:block/{name}"},
    }


def sign_round(name):
    return {
        "parent": f"{MOD_ID}:block/template/sign_round",
        "textures": {"sign": f"{MOD_ID}:block/{name}"},
    }


def sign_square(name):
    return {
        "parent": f"{MOD_ID}:block/template/sign_square",
        "textures": {"sign": f"{MOD_ID}:block/{name}"},
    }


def sign_triangle(name):
    return {
        "parent": f"{MOD_ID}:block/template/sign_triangle",
        "textures": {"sign": f"{MOD_ID}:block/{name}"},
    }
