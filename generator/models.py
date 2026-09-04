MOD_ID = "cityparts"


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
        "parent": f"{MOD_ID}:block/template/roadlines_marking",
        "textures": {"marking": f"{MOD_ID}:block/{name}"},
    }


def road_slab(name):
    return {
        "parent": f"{MOD_ID}:block/template/roadlines_slab_marking",
        "textures": {"marking": f"{MOD_ID}:block/{name}"},
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


def button(name):
    return {"parent": "minecraft:block/button", "textures": {"texture": f"{MOD_ID}:block/{name}"}}


def button_inventory(name):
    return {"parent": "minecraft:block/button_inventory", "textures": {"texture": f"{MOD_ID}:block/{name}"}}


def button_pressed(name):
    return {"parent": "minecraft:block/button_pressed", "textures": {"texture": f"{MOD_ID}:block/{name}"}}


def pressure_plate(name):
    return {"parent": "minecraft:block/pressure_plate_up", "textures": {"texture": f"{MOD_ID}:block/{name}"}}


def pressure_plate_down(name):
    return {"parent": "minecraft:block/pressure_plate_down", "textures": {"texture": f"{MOD_ID}:block/{name}"}}


def fence_inventory(name):
    return {"parent": "minecraft:block/fence_inventory", "textures": {"texture": f"{MOD_ID}:block/{name}"}}


def fence_post(name):
    return {"parent": "minecraft:block/fence_post", "textures": {"texture": f"{MOD_ID}:block/{name}"}}


def fence_side(name):
    return {"parent": "minecraft:block/fence_side", "textures": {"texture": f"{MOD_ID}:block/{name}"}}


def fence_gate(name):
    return {"parent": "minecraft:block/template_fence_gate", "textures": {"texture": f"{MOD_ID}:block/{name}"}}


def fence_gate_open(name):
    return {
        "parent": "minecraft:block/template_fence_gate_open",
        "textures": {"texture": f"{MOD_ID}:block/{name}"},
    }


def fence_gate_wall(name):
    return {
        "parent": "minecraft:block/template_fence_gate_wall",
        "textures": {"texture": f"{MOD_ID}:block/{name}"},
    }


def fence_gate_wall_open(name):
    return {
        "parent": "minecraft:block/template_fence_gate_wall_open",
        "textures": {"texture": f"{MOD_ID}:block/{name}"},
    }


def door_bottom_left(name):
    return {
        "parent": "minecraft:block/door_bottom_left",
        "textures": {"bottom": f"{MOD_ID}:block/{name}_bottom", "top": f"{MOD_ID}:block/{name}_top"},
    }


def door_bottom_left_open(name):
    return {
        "parent": "minecraft:block/door_bottom_left_open",
        "textures": {"bottom": f"{MOD_ID}:block/{name}_bottom", "top": f"{MOD_ID}:block/{name}_top"},
    }


def door_bottom_right(name):
    return {
        "parent": "minecraft:block/door_bottom_right",
        "textures": {"bottom": f"{MOD_ID}:block/{name}_bottom", "top": f"{MOD_ID}:block/{name}_top"},
    }


def door_bottom_right_open(name):
    return {
        "parent": "minecraft:block/door_bottom_right_open",
        "textures": {"bottom": f"{MOD_ID}:block/{name}_bottom", "top": f"{MOD_ID}:block/{name}_top"},
    }


def door_top_left(name):
    return {
        "parent": "minecraft:block/door_top_left",
        "textures": {"bottom": f"{MOD_ID}:block/{name}_bottom", "top": f"{MOD_ID}:block/{name}_top"},
    }


def door_top_left_open(name):
    return {
        "parent": "minecraft:block/door_top_left_open",
        "textures": {"bottom": f"{MOD_ID}:block/{name}_bottom", "top": f"{MOD_ID}:block/{name}_top"},
    }


def door_top_right(name):
    return {
        "parent": "minecraft:block/door_top_right",
        "textures": {"bottom": f"{MOD_ID}:block/{name}_bottom", "top": f"{MOD_ID}:block/{name}_top"},
    }


def door_top_right_open(name):
    return {
        "parent": "minecraft:block/door_top_right_open",
        "textures": {"bottom": f"{MOD_ID}:block/{name}_bottom", "top": f"{MOD_ID}:block/{name}_top"},
    }


def trapdoor_open(name):
    return {
        "parent": "minecraft:block/template_orientable_trapdoor_open",
        "textures": {"texture": f"{MOD_ID}:block/{name}"},
    }


def trapdoor_top(name):
    return {
        "parent": "minecraft:block/template_orientable_trapdoor_top",
        "textures": {"texture": f"{MOD_ID}:block/{name}"},
    }


def trapdoor_bottom(name):
    return {
        "parent": "minecraft:block/template_orientable_trapdoor_bottom",
        "textures": {"texture": f"{MOD_ID}:block/{name}"},
    }


def block_particle(texture):
    return {"textures": {"particle": f"{MOD_ID}:block/{texture}"}}
