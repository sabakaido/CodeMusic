package org.codemusic.sample;

import javax.sound.midi.*;

/**
 * Created by anikaido on 2017/02/12.
 */
public class SynthesizerSingleton {
    private static SynthesizerSingleton instance;
    private static MidiChannel midiChannel;

    private SynthesizerSingleton() {
    }

    public static SynthesizerSingleton getInstance() throws MidiUnavailableException {
        if (instance == null) {
            instance = new SynthesizerSingleton();
            Synthesizer synthesizer = MidiSystem.getSynthesizer();

            synthesizer.open();
            Instrument[] instruments = synthesizer.getDefaultSoundbank().getInstruments();
            synthesizer.loadInstrument(instruments[0]);
            midiChannel = synthesizer.getChannels()[0];
        }

        return instance;
    }

    public MidiChannel getMidiChannel() {
        return midiChannel;
    }
}
