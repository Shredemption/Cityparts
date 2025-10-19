MOD_ID = "cityparts"


def block(name):
    return {"parent": f"{MOD_ID}:block/{name}"}


def block_inventory(name):
    return {"parent": f"{MOD_ID}:block/{name}_inventory"}


def block_bottom(name):
    return {"parent": f"{MOD_ID}:block/{name}_bottom"}


def light(color, type):
    return {"parent": f"{MOD_ID}:block/light_{color}_{type}"}


def block_texture(name):
    return {"parent": "item/generated", "textures": {"layer0": f"{MOD_ID}:block/{name}"}}


def item_texture(name):
    return {"parent": "item/generated", "textures": {"layer0": f"{MOD_ID}:item/{name}"}}

