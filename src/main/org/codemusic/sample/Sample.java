package org.codemusic.sample;

import org.codemusic.sample.model.MusicalScale;

import javax.sound.midi.*;

/**
 * Created by anikaido on 2017/02/12.
 */
public class Sample {
    public static void main (String args[]) {
        MidiChannel channel = null;
        try {
            soundC();
            soundG7();
            soundC();
        } catch(Exception e){
            if(channel != null)  channel.allNotesOff();
        }
        System.exit(0);
    }

    public static void soundC() throws InterruptedException, MidiUnavailableException {
        SoundManager.sound(
                MusicalScale.DO.getValue(),
                MusicalScale.MI.getValue(),
                MusicalScale.SO.getValue()
        );
    }

    public static void soundG7() throws InterruptedException, MidiUnavailableException {
        SoundManager.sound(
                MusicalScale.SI.getValue(),
                MusicalScale.RE.getValue(),
                MusicalScale.SO.getValue()
        );
    }

    public static void soundD() throws InterruptedException, MidiUnavailableException {
        SoundManager.sound(
                MusicalScale.RE.getValue(),
                MusicalScale.FA.getValue(),
                MusicalScale.RA.getValue()
        );
    }
}
