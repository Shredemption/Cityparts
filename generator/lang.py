import os
import json

MOD_ID = "cityparts"

BASE_PATH = r"./src/main/resources/"

LANG_PATHS = {
    "en": os.path.join(BASE_PATH, f"assets/{MOD_ID}/lang/en_us.json"),
    "nl": os.path.join(BASE_PATH, f"assets/{MOD_ID}/lang/nl_nl.json"),
}


COLOR_NAMES = {
    "en": {
        "gray": "Gray",
        "white": "White",
        "black": "Black",
        "green": "Green",
    },
    "nl": {
        "gray": "Grijs",
        "white": "Wit",
        "black": "Zwart",
        "green": "Groen",
    },
}


LIGHT_PART_NAMES = {
    "en": {
        "post": "Post",
        "arm": "Arm",
        "corner": "Corner",
        "corner": "Corner Post",
        "l_corner": "L Corner",
        "l_corner_post": "L Corner Post",
        "t_corner": "T Corner",
        "t_corner_post": "T Corner Post",
        "y_corner": "Y Corner",
        "y_corner_post": "Y Corner Post",
        "x_corner": "X Corner",
        "x_corner_post": "X Corner Post",
        "light": "Light",
    },
    "nl": {
        "post": "Paal",
        "arm": "Arm",
        "corner": "Hoek",
        "corner": "Hoek Paal",
        "l_corner": "L Hoek",
        "l_corner": "L Hoek Paal",
        "t_corner": "T Hoek",
        "t_corner": "T Hoek Paal",
        "y_corner": "Y Hoek",
        "y_corner": "Y Hoek Paal",
        "x_corner": "X Hoek",
        "x_corner": "X Hoek Paal",
        "light": "Lamp",
    },
}


def load_lang(path):
    if os.path.exists(path):
        with open(path, "r", encoding="utf-8") as f:
            return json.load(f)

    return {}


def save_lang(path, lang):
    lang = dict(sorted(lang.items()))

    with open(path, "w", encoding="utf-8") as f:
        json.dump(lang, f, indent=4, ensure_ascii=False)
        f.write("\n")


def generate_lights(lang, language):
    colors = COLOR_NAMES[language]
    parts = LIGHT_PART_NAMES[language]

    for color, color_name in colors.items():

        for part, part_name in parts.items():

            key = f"block.{MOD_ID}.light_{color}_{part}"

            lang[key] = f"{color_name} {part_name}"


def update_language_file(language):
    path = LANG_PATHS[language]

    lang = load_lang(path)

    generate_lights(lang, language)

    save_lang(path, lang)

    print(f"Updated {language}: {path}")


update_language_file("en")
update_language_file("nl")

print("\nLanguage files updated successfully!")
