package org.codemusic.sample;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import java.math.BigInteger;

/**
 * Created by anikaido on 2017/02/12.
 */
public class Sample {
    public static void main (String args[]) {
        MidiChannel channel = null;
        try {
            Synthesizer synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            Instrument[] instruments = synthesizer.getDefaultSoundbank().getInstruments();
            synthesizer.loadInstrument(instruments[0]);
            channel = synthesizer.getChannels()[0];
            soundCollatz(channel, new BigInteger("837799"));
            synthesizer.close();
        } catch(Exception e){
            if(channel != null)  channel.allNotesOff();
        }
        System.exit(0);
    }

    public static BigInteger collatz(BigInteger n){
        if(n.mod(new BigInteger("2")).compareTo(new BigInteger("0")) == 0){
            return n.divide(new BigInteger("2"));
        }else{
            return n.multiply(new BigInteger("3")).add(new BigInteger("1"));
        }
    }

    public static void soundCollatz(MidiChannel channel, BigInteger n) throws InterruptedException{
        BigInteger a = n;
        while(a.compareTo(new BigInteger("1")) != 0){
            System.out.println(a);
            sound(channel, a.mod(new BigInteger("127")).intValue());
            a = collatz(a);
        }
    }

    public static void sound(MidiChannel channel, int n) throws InterruptedException{
        channel.noteOn(n , 127);
        Thread.currentThread();
        Thread.sleep(256);
        channel.noteOff(128);
    }
}
