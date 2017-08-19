package com.sarryromain.metacriticapi.review.enums;

/**
 * Created by Romain on 30/07/2017.
 */
public enum MetacriticGamePlatform {
    /* Master Race */
    PC ("pc"),

    /* Sony */
    PS ("playstation"),
    PS2 ("playstation-2"),
    PS3 ("playstation-3"),
    PS4 ("playstation-4"),
    PSP ("psp"),
    PSVita ("playstation-vita"),

    /* Microsoft */
    Xbox ("xbox"),
    Xbox360 ("xbox-360"),
    XboxOne ("xbox-one"),

    /* Nintendo */
    N64 ("nintendo-64"),
    Gamecube ("gamecube"),
    Wii ("wii"),
    WiiU ("wii-u"),
    Switch ("switch"),
    GBA ("game-boy-advance"),
    DS ("ds"),
    ThreeDS ("3ds"),

    /* Sega */
    Dreamcast ("dreamcast");

    private String platform;

    MetacriticGamePlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
