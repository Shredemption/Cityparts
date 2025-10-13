MOD_ID = "streetparts"


def block(name):
    return {"parent": f"{MOD_ID}:block/{name}"}


def wall(name):
    return {"parent": f"{MOD_ID}:block/{name}_inventory"}


def light(color, type):
    return {"parent": f"{MOD_ID}:block/light_{color}_{type}"}


def block_texture(name):
    return {"parent": "item/generated", "textures": {"layer0": f"{MOD_ID}:block/{name}"}}
