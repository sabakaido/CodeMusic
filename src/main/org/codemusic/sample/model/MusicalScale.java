package org.codemusic.sample.model;

/**
 * Created by anikaido on 2017/02/12.
 */
public enum MusicalScale {
    DO(60),
    DO_SHARP(61),
    RE(62),
    RE_SHARP(63),
    MI(64),
    FA(65),
    FA_SHARP(66),
    SO(67),
    SO_SHARP(68),
    RA(69),
    RA_SHARP(70),
    SI(71),
    ;

    private final int id;

    private MusicalScale(final int id) {
        this.id = id;
    }

    public int getValue() {
        return this.id;
    }
}
