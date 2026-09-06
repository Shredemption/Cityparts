MOD_ID = "cityparts"


def block(name):
    return {"parent": f"{MOD_ID}:block/{name}"}


def road_block(name):
    return {
        "parent": f"{MOD_ID}:item/template/roadlines_item",
        "textures": {"marking": f"{MOD_ID}:block/{name}"},
    }


def road_slab(name):
    return {
        "parent": f"{MOD_ID}:item/template/roadlines_item_slab",
        "textures": {"marking": f"{MOD_ID}:block/{name}"},
    }


def block_inventory(name):
    return {"parent": f"{MOD_ID}:block/{name}_inventory"}


def block_bottom(name):
    return {"parent": f"{MOD_ID}:block/{name}_bottom"}


def light(color, type):
    return {
        "parent": f"{MOD_ID}:block/template/light_{type}",
        "textures": {"0": f"{MOD_ID}:block/{color}_post"},
    }


def light_light(color, type, state):
    return {
        "parent": f"{MOD_ID}:block/template/light_{type}",
        "textures": {
            "0": f"{MOD_ID}:block/{color}_post",
            "1": f"{MOD_ID}:block/lamp_{state}",
        },
    }


def block_texture(name):
    return {"parent": "item/generated", "textures": {"layer0": f"{MOD_ID}:block/{name}"}}


def item_texture(name):
    return {"parent": "item/generated", "textures": {"layer0": f"{MOD_ID}:item/{name}"}}
