MOD_ID = "streetparts"


def block_drops(name):
    return {
        "type": "minecraft:block",
        "pools": [
            {
                "bonus_rolls": 0.0,
                "conditions": [{"condition": "minecraft:survives_explosion"}],
                "entries": [{"type": "minecraft:item", "name": f"{MOD_ID}:{name}"}],
                "rolls": 1.0,
            }
        ],
        "random_sequence": f"{MOD_ID}:blocks/{name}",
    }


def door(name):
    return {
        "type": "minecraft:block",
        "pools": [
            {
                "bonus_rolls": 0.0,
                "conditions": [{"condition": "minecraft:survives_explosion"}],
                "entries": [
                    {
                        "type": "minecraft:item",
                        "conditions": [
                            {
                                "block": f"{MOD_ID}:{name}",
                                "condition": "minecraft:block_state_property",
                                "properties": {"half": "lower"},
                            }
                        ],
                        "name": f"{MOD_ID}:{name}",
                    }
                ],
                "rolls": 1.0,
            }
        ],
        "random_sequence": f"{MOD_ID}:blocks/{name}",
    }
