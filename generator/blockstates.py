MOD_ID = "streetparts"


def block(name):
    return {"variants": {"": {"model": f"{MOD_ID}:block/{name}"}}}


def stairs(name):
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


def slab(name):
    return {
        "variants": {
            "type=bottom": {"model": f"{MOD_ID}:block/{name}_slab"},
            "type=top": {"model": f"{MOD_ID}:block/{name}_slab_top"},
            "type=double": {"model": f"{MOD_ID}:block/{name}"},
        }
    }


def wall(name):
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


def horizontalRotating(name):
    return {
        "variants": {
            "facing=north": {"model": f"{MOD_ID}:block/{name}"},
            "facing=south": {"model": f"{MOD_ID}:block/{name}", "y": 180},
            "facing=west": {"model": f"{MOD_ID}:block/{name}", "y": 270},
            "facing=east": {"model": f"{MOD_ID}:block/{name}", "y": 90},
        }
    }


def light(color, type):
    return {
        "variants": {
            "facing=north": {"model": f"{MOD_ID}:block/light_{color}_{type}"},
            "facing=south": {"model": f"{MOD_ID}:block/light_{color}_{type}", "y": 180},
            "facing=west": {"model": f"{MOD_ID}:block/light_{color}_{type}", "y": 270},
            "facing=east": {"model": f"{MOD_ID}:block/light_{color}_{type}", "y": 90},
        }
    }


def pillar(name):
    return {
        "variants": {
            "axis=x": {"model": f"{MOD_ID}:block/{name}_horizontal", "x": 90, "y": 90},
            "axis=y": {"model": f"{MOD_ID}:block/{name}"},
            "axis=z": {"model": f"{MOD_ID}:block/{name}_horizontal", "x": 90},
        }
    }


def button(name):
    return {
        "variants": {
            "face=ceiling,facing=east,powered=false": {"model": f"{MOD_ID}:block/{name}", "x": 180, "y": 270},
            "face=ceiling,facing=east,powered=true": {
                "model": f"{MOD_ID}:block/{name}_pressed",
                "x": 180,
                "y": 270,
            },
            "face=ceiling,facing=north,powered=false": {"model": f"{MOD_ID}:block/{name}", "x": 180, "y": 180},
            "face=ceiling,facing=north,powered=true": {
                "model": f"{MOD_ID}:block/{name}_pressed",
                "x": 180,
                "y": 180,
            },
            "face=ceiling,facing=south,powered=false": {"model": f"{MOD_ID}:block/{name}", "x": 180},
            "face=ceiling,facing=south,powered=true": {"model": f"{MOD_ID}:block/{name}_pressed", "x": 180},
            "face=ceiling,facing=west,powered=false": {"model": f"{MOD_ID}:block/{name}", "x": 180, "y": 90},
            "face=ceiling,facing=west,powered=true": {
                "model": f"{MOD_ID}:block/{name}_pressed",
                "x": 180,
                "y": 90,
            },
            "face=floor,facing=east,powered=false": {"model": f"{MOD_ID}:block/{name}", "y": 90},
            "face=floor,facing=east,powered=true": {"model": f"{MOD_ID}:block/{name}_pressed", "y": 90},
            "face=floor,facing=north,powered=false": {"model": f"{MOD_ID}:block/{name}"},
            "face=floor,facing=north,powered=true": {"model": f"{MOD_ID}:block/{name}_pressed"},
            "face=floor,facing=south,powered=false": {"model": f"{MOD_ID}:block/{name}", "y": 180},
            "face=floor,facing=south,powered=true": {"model": f"{MOD_ID}:block/{name}_pressed", "y": 180},
            "face=floor,facing=west,powered=false": {"model": f"{MOD_ID}:block/{name}", "y": 270},
            "face=floor,facing=west,powered=true": {"model": f"{MOD_ID}:block/{name}_pressed", "y": 270},
            "face=wall,facing=east,powered=false": {
                "model": f"{MOD_ID}:block/{name}",
                "uvlock": "true",
                "x": 90,
                "y": 90,
            },
            "face=wall,facing=east,powered=true": {
                "model": f"{MOD_ID}:block/{name}_pressed",
                "uvlock": "true",
                "x": 90,
                "y": 90,
            },
            "face=wall,facing=north,powered=false": {
                "model": f"{MOD_ID}:block/{name}",
                "uvlock": "true",
                "x": 90,
            },
            "face=wall,facing=north,powered=true": {
                "model": f"{MOD_ID}:block/{name}_pressed",
                "uvlock": "true",
                "x": 90,
            },
            "face=wall,facing=south,powered=false": {
                "model": f"{MOD_ID}:block/{name}",
                "uvlock": "true",
                "x": 90,
                "y": 180,
            },
            "face=wall,facing=south,powered=true": {
                "model": f"{MOD_ID}:block/{name}_pressed",
                "uvlock": "true",
                "x": 90,
                "y": 180,
            },
            "face=wall,facing=west,powered=false": {
                "model": f"{MOD_ID}:block/{name}",
                "uvlock": "true",
                "x": 90,
                "y": 270,
            },
            "face=wall,facing=west,powered=true": {
                "model": f"{MOD_ID}:block/{name}_pressed",
                "uvlock": "true",
                "x": 90,
                "y": 270,
            },
        }
    }


def pressure_plate(name):
    return {
        "variants": {
            "powered=false": {"model": f"{MOD_ID}:block/{name}"},
            "powered=true": {"model": f"{MOD_ID}:block/{name}_down"},
        }
    }
