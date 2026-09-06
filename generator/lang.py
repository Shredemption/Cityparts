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
        "post_lamp": "Post Lamp",
        "arm": "Arm",
        "corner": "Corner",
        "corner_post": "Corner Post",
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
        "post_lamp": "Paal Lamp",
        "arm": "Arm",
        "corner": "Hoek",
        "corner_post": "Hoek Paal",
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

SIGN_NAMES = {
    "en": {
        "round": {
            "stop": "Stop Sign",
            "no_entry": "No Entry Sign",
            "roundabout": "Roundabout Sign",
            "left_pass": "Left Pass Sign",
            "left_right_pass": "Left + Right Pass Sign",
            "right_pass": "Right Pass Sign",
            "arrow_left": "Left Arrow Sign",
            "arrow_forward": "Forward Arrow Sign",
            "arrow_right": "Right Arrow Sign",
            "arrow_forward_left": "Forward + Left Arrow Sign",
            "arrow_left_right": "Left + Right Arrow Sign",
            "arrow_forward_right": "Forward + Right Arrow Sign",
            "5": "Max Speed 5 Sign",
            "10": "Max Speed 10 Sign",
            "15": "Max Speed 15 Sign",
            "30": "Max Speed 30 Sign",
            "50": "Max Speed 50 Sign",
            "60": "Max Speed 60 Sign",
            "70": "Max Speed 70 Sign",
            "80": "Max Speed 80 Sign",
            "90": "Max Speed 90 Sign",
            "100": "Max Speed 100 Sign",
            "120": "Max Speed 120 Sign",
            "130": "Max Speed 130 Sign",
            "end_speed": "End of Max Speed Sign",
            "oncoming_yield": "Yield For Oncoming Sign",
            "no_parking": "No Parking Sign",
            "no_stopping": "No Stopping Sign",
        },
        "square": {
            "arrow_left": "Left Arrow Sign",
            "arrow_forward": "Forward Arrow Sign",
            "arrow_right": "Right Arrow Sign",
            "arrow_forward_left": "Forward + Left Arrow Sign",
            "arrow_left_right": "Left + Right Arrow Sign",
            "arrow_forward_right": "Forward + Right Arrow Sign",
            "oncoming_priority": "Priority Over Oncoming Sign",
            "parking": "Parking Place Sign",
        },
        "triangle": {
            "warning": "Generic Warning Sign",
            "danger": "Generic Danger Sign",
            "danger_cross": "Dangerous Crossing Sign",
            "crossing_left": "Priority Over Left Sign",
            "crossing_left_right": "Priority Over Left + Right Sign",
            "crossing_right": "Priority Over Right Sign",
            "sharp_left": "Sharp Left Turn Sign",
            "sharp_right": "Sharp Right Turn Sign",
        },
    },
    "nl": {
        "round": {
            "stop": "Stopbord",
            "no_entry": "Verboden toegang bord",
            "roundabout": "Rotonde bord",
            "left_pass": "Links voorbij bord",
            "left_right_pass": "Links + rechts voorbij bord",
            "right_pass": "Rechts voorbij bord",
            "arrow_left": "Pijl links bord",
            "arrow_forward": "Pijl vooruit bord",
            "arrow_right": "Pijl rechts bord",
            "arrow_forward_left": "Pijl vooruit + links bord",
            "arrow_left_right": "Pijl links + rechts bord",
            "arrow_forward_right": "Pijl vooruit + rechts bord",
            "5": "Maximum snelheid 5 bord",
            "10": "Maximum snelheid 10 bord",
            "15": "Maximum snelheid 15 bord",
            "30": "Maximum snelheid 30 bord",
            "50": "Maximum snelheid 50 bord",
            "60": "Maximum snelheid 60 bord",
            "70": "Maximum snelheid 70 bord",
            "80": "Maximum snelheid 80 bord",
            "90": "Maximum snelheid 90 bord",
            "100": "Maximum snelheid 100 bord",
            "120": "Maximum snelheid 120 bord",
            "130": "Maximum snelheid 130 bord",
            "end_speed": "Einde maximum snelheid bord",
            "oncoming_yield": "Tegemoetkomend voorrang geven bord",
            "no_parking": "Niet parkeren bord",
            "no_stopping": "Niet stilstaan bord",
        },
        "square": {
            "arrow_left": "Pijl links bord",
            "arrow_forward": "Pijl vooruit bord",
            "arrow_right": "Pijl rechts bord",
            "arrow_forward_left": "Pijl vooruit + links bord",
            "arrow_left_right": "Pijl links + rechts bord",
            "arrow_forward_right": "Pijl vooruit + rechts bord",
            "oncoming_priority": "Voorrang over tegemoetkomend bord",
            "parking": "Parkeerplaats bord",
        },
        "triangle": {
            "warning": "Waarschuwingsbord",
            "danger": "Gevaarsbord",
            "danger_cross": "Gevaarlijke kruising bord",
            "crossing_left": "Voorrang over links bord",
            "crossing_left_right": "Voorrang over links + rechts bord",
            "crossing_right": "Voorrang over rechts bord",
            "sharp_left": "Scherpe bocht links bord",
            "sharp_right": "Scherpe bocht rechts bord",
        },
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


def generate_signs(lang, language):
    signs = SIGN_NAMES[language]

    for shape, sign_names in signs.items():

        for sign, sign_name in sign_names.items():

            key = f"block.{MOD_ID}.sign_{shape}_{sign}"

            lang[key] = sign_name


def update_language_file(language):
    path = LANG_PATHS[language]

    lang = load_lang(path)

    generate_lights(lang, language)
    generate_signs(lang, language)

    save_lang(path, lang)

    print(f"Updated {language}: {path}")


update_language_file("en")
update_language_file("nl")

print("\nLanguage files updated successfully!")
