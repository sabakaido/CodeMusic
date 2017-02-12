package org.codemusic.sample;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiUnavailableException;
import java.util.Arrays;

/**
 * Created by anikaido on 2017/02/12.
 */
public class SoundManager {
    public static void sound(int... musicScaleList) throws MidiUnavailableException, InterruptedException {
        MidiChannel channel = SynthesizerSingleton.getInstance().getMidiChannel();

        Arrays.stream(musicScaleList).forEach(
                scale -> {
                    channel.noteOn(scale, 127);
                }
        );

        Thread.currentThread();
        Thread.sleep(512);
        channel.noteOff(128);
        Thread.sleep(512);
    }

    private SoundManager() {
        // インスタンス化させない
        throw new AssertionError();
    }
}
