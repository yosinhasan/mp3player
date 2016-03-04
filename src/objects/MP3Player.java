package objects;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

// класс для проигрывания mp3 файлов
public class MP3Player {

    private BasicPlayer player = new BasicPlayer();
    
    private String currentFileName;// текущая песня
    private double currentVolumeValue;// текущий уровень звука

    
    public void play(String fileName) {

        try {
            // если включают ту же самую песню, которая была на паузе
            if (currentFileName != null && currentFileName.equals(fileName) && player.getStatus() == BasicPlayer.PAUSED) {
                player.resume();
                return;
            }
            
            currentFileName = fileName;
            player.open(new File(fileName));
            player.play();
            player.setGain(currentVolumeValue);// устанавливаем уровень звука


        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void stop() {
        try {
            player.stop();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pause() {
        try {
            player.pause();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // регулирует звук при проигрывании песни
    public void setVolume(int currentValue, int maximumValue) {
        try {
            this.currentVolumeValue = currentValue;
            
            if (currentValue == 0) {
                player.setGain(0);
            } else {                
                player.setGain(calcVolume(currentValue, maximumValue));
            }

        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // подсчитать значение звука исходя из значений компонента регулировки звука (JSlider)
    private double calcVolume(int currentValue, int maximumValue) {
        currentVolumeValue = (double) currentValue / (double) maximumValue;
        return currentVolumeValue;
    }
    
    
    public void seek(long l){
        try {
            player.seek(1028469);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
