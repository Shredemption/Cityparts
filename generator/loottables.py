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
