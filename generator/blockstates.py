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


def slab_planks(name):
    return {
        "variants": {
            "type=bottom": {"model": f"{MOD_ID}:block/{name}_slab"},
            "type=top": {"model": f"{MOD_ID}:block/{name}_slab_top"},
            "type=double": {"model": f"{MOD_ID}:block/{name}_planks"},
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


def fence(name):
    return {
        "multipart": [
            {"apply": {"model": f"{MOD_ID}:block/{name}_post"}},
            {"apply": {"model": f"{MOD_ID}:block/{name}_side", "uvlock": "true"}, "when": {"north": "true"}},
            {
                "apply": {"model": f"{MOD_ID}:block/{name}_side", "uvlock": "true", "y": 90},
                "when": {"east": "true"},
            },
            {
                "apply": {"model": f"{MOD_ID}:block/{name}_side", "uvlock": "true", "y": 180},
                "when": {"south": "true"},
            },
            {
                "apply": {"model": f"{MOD_ID}:block/{name}_side", "uvlock": "true", "y": 270},
                "when": {"west": "true"},
            },
        ]
    }


def fence_gate(name):
    return {
        "variants": {
            "facing=east,in_wall=false,open=false": {
                "model": f"{MOD_ID}:block/{name}",
                "uvlock": "true",
                "y": 270,
            },
            "facing=east,in_wall=false,open=true": {
                "model": f"{MOD_ID}:block/{name}_open",
                "uvlock": "true",
                "y": 270,
            },
            "facing=east,in_wall=true,open=false": {
                "model": f"{MOD_ID}:block/{name}_wall",
                "uvlock": "true",
                "y": 270,
            },
            "facing=east,in_wall=true,open=true": {
                "model": f"{MOD_ID}:block/{name}_wall_open",
                "uvlock": "true",
                "y": 270,
            },
            "facing=north,in_wall=false,open=false": {
                "model": f"{MOD_ID}:block/{name}",
                "uvlock": "true",
                "y": 180,
            },
            "facing=north,in_wall=false,open=true": {
                "model": f"{MOD_ID}:block/{name}_open",
                "uvlock": "true",
                "y": 180,
            },
            "facing=north,in_wall=true,open=false": {
                "model": f"{MOD_ID}:block/{name}_wall",
                "uvlock": "true",
                "y": 180,
            },
            "facing=north,in_wall=true,open=true": {
                "model": f"{MOD_ID}:block/{name}_wall_open",
                "uvlock": "true",
                "y": 180,
            },
            "facing=south,in_wall=false,open=false": {"model": f"{MOD_ID}:block/{name}", "uvlock": "true"},
            "facing=south,in_wall=false,open=true": {
                "model": f"{MOD_ID}:block/{name}_open",
                "uvlock": "true",
            },
            "facing=south,in_wall=true,open=false": {
                "model": f"{MOD_ID}:block/{name}_wall",
                "uvlock": "true",
            },
            "facing=south,in_wall=true,open=true": {
                "model": f"{MOD_ID}:block/{name}_wall_open",
                "uvlock": "true",
            },
            "facing=west,in_wall=false,open=false": {
                "model": f"{MOD_ID}:block/{name}",
                "uvlock": "true",
                "y": 90,
            },
            "facing=west,in_wall=false,open=true": {
                "model": f"{MOD_ID}:block/{name}_open",
                "uvlock": "true",
                "y": 90,
            },
            "facing=west,in_wall=true,open=false": {
                "model": f"{MOD_ID}:block/{name}_wall",
                "uvlock": "true",
                "y": 90,
            },
            "facing=west,in_wall=true,open=true": {
                "model": f"{MOD_ID}:block/{name}_wall_open",
                "uvlock": "true",
                "y": 90,
            },
        }
    }


def door(name):
    return {
        "variants": {
            "facing=east,half=lower,hinge=left,open=false": {"model": f"{MOD_ID}:block/{name}_bottom_left"},
            "facing=east,half=lower,hinge=left,open=true": {
                "model": f"{MOD_ID}:block/{name}_bottom_left_open",
                "y": 90,
            },
            "facing=east,half=lower,hinge=right,open=false": {"model": f"{MOD_ID}:block/{name}_bottom_right"},
            "facing=east,half=lower,hinge=right,open=true": {
                "model": f"{MOD_ID}:block/{name}_bottom_right_open",
                "y": 270,
            },
            "facing=east,half=upper,hinge=left,open=false": {"model": f"{MOD_ID}:block/{name}_top_left"},
            "facing=east,half=upper,hinge=left,open=true": {
                "model": f"{MOD_ID}:block/{name}_top_left_open",
                "y": 90,
            },
            "facing=east,half=upper,hinge=right,open=false": {"model": f"{MOD_ID}:block/{name}_top_right"},
            "facing=east,half=upper,hinge=right,open=true": {
                "model": f"{MOD_ID}:block/{name}_top_right_open",
                "y": 270,
            },
            "facing=north,half=lower,hinge=left,open=false": {
                "model": f"{MOD_ID}:block/{name}_bottom_left",
                "y": 270,
            },
            "facing=north,half=lower,hinge=left,open=true": {"model": f"{MOD_ID}:block/{name}_bottom_left_open"},
            "facing=north,half=lower,hinge=right,open=false": {
                "model": f"{MOD_ID}:block/{name}_bottom_right",
                "y": 270,
            },
            "facing=north,half=lower,hinge=right,open=true": {
                "model": f"{MOD_ID}:block/{name}_bottom_right_open",
                "y": 180,
            },
            "facing=north,half=upper,hinge=left,open=false": {
                "model": f"{MOD_ID}:block/{name}_top_left",
                "y": 270,
            },
            "facing=north,half=upper,hinge=left,open=true": {"model": f"{MOD_ID}:block/{name}_top_left_open"},
            "facing=north,half=upper,hinge=right,open=false": {
                "model": f"{MOD_ID}:block/{name}_top_right",
                "y": 270,
            },
            "facing=north,half=upper,hinge=right,open=true": {
                "model": f"{MOD_ID}:block/{name}_top_right_open",
                "y": 180,
            },
            "facing=south,half=lower,hinge=left,open=false": {
                "model": f"{MOD_ID}:block/{name}_bottom_left",
                "y": 90,
            },
            "facing=south,half=lower,hinge=left,open=true": {
                "model": f"{MOD_ID}:block/{name}_bottom_left_open",
                "y": 180,
            },
            "facing=south,half=lower,hinge=right,open=false": {
                "model": f"{MOD_ID}:block/{name}_bottom_right",
                "y": 90,
            },
            "facing=south,half=lower,hinge=right,open=true": {"model": f"{MOD_ID}:block/{name}_bottom_right_open"},
            "facing=south,half=upper,hinge=left,open=false": {
                "model": f"{MOD_ID}:block/{name}_top_left",
                "y": 90,
            },
            "facing=south,half=upper,hinge=left,open=true": {
                "model": f"{MOD_ID}:block/{name}_top_left_open",
                "y": 180,
            },
            "facing=south,half=upper,hinge=right,open=false": {
                "model": f"{MOD_ID}:block/{name}_top_right",
                "y": 90,
            },
            "facing=south,half=upper,hinge=right,open=true": {"model": f"{MOD_ID}:block/{name}_top_right_open"},
            "facing=west,half=lower,hinge=left,open=false": {
                "model": f"{MOD_ID}:block/{name}_bottom_left",
                "y": 180,
            },
            "facing=west,half=lower,hinge=left,open=true": {
                "model": f"{MOD_ID}:block/{name}_bottom_left_open",
                "y": 270,
            },
            "facing=west,half=lower,hinge=right,open=false": {
                "model": f"{MOD_ID}:block/{name}_bottom_right",
                "y": 180,
            },
            "facing=west,half=lower,hinge=right,open=true": {
                "model": f"{MOD_ID}:block/{name}_bottom_right_open",
                "y": 90,
            },
            "facing=west,half=upper,hinge=left,open=false": {
                "model": f"{MOD_ID}:block/{name}_top_left",
                "y": 180,
            },
            "facing=west,half=upper,hinge=left,open=true": {
                "model": f"{MOD_ID}:block/{name}_top_left_open",
                "y": 270,
            },
            "facing=west,half=upper,hinge=right,open=false": {
                "model": f"{MOD_ID}:block/{name}_top_right",
                "y": 180,
            },
            "facing=west,half=upper,hinge=right,open=true": {
                "model": f"{MOD_ID}:block/{name}_top_right_open",
                "y": 90,
            },
        }
    }


def trapdoor(name):
    return {
        "variants": {
            "facing=east,half=bottom,open=false": {"model": f"{MOD_ID}:block/{name}_bottom", "y": 90},
            "facing=east,half=bottom,open=true": {"model": f"{MOD_ID}:block/{name}_open", "y": 90},
            "facing=east,half=top,open=false": {"model": f"{MOD_ID}:block/{name}_top", "y": 90},
            "facing=east,half=top,open=true": {"model": f"{MOD_ID}:block/{name}_open", "x": 180, "y": 270},
            "facing=north,half=bottom,open=false": {"model": f"{MOD_ID}:block/{name}_bottom"},
            "facing=north,half=bottom,open=true": {"model": f"{MOD_ID}:block/{name}_open"},
            "facing=north,half=top,open=false": {"model": f"{MOD_ID}:block/{name}_top"},
            "facing=north,half=top,open=true": {"model": f"{MOD_ID}:block/{name}_open", "x": 180, "y": 180},
            "facing=south,half=bottom,open=false": {"model": f"{MOD_ID}:block/{name}_bottom", "y": 180},
            "facing=south,half=bottom,open=true": {"model": f"{MOD_ID}:block/{name}_open", "y": 180},
            "facing=south,half=top,open=false": {"model": f"{MOD_ID}:block/{name}_top", "y": 180},
            "facing=south,half=top,open=true": {"model": f"{MOD_ID}:block/{name}_open", "x": 180, "y": 0},
            "facing=west,half=bottom,open=false": {"model": f"{MOD_ID}:block/{name}_bottom", "y": 270},
            "facing=west,half=bottom,open=true": {"model": f"{MOD_ID}:block/{name}_open", "y": 270},
            "facing=west,half=top,open=false": {"model": f"{MOD_ID}:block/{name}_top", "y": 270},
            "facing=west,half=top,open=true": {"model": f"{MOD_ID}:block/{name}_open", "x": 180, "y": 90},
        }
    }