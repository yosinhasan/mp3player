package utils;

import mp3_gui.mp3Player;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SkinUtils {

    public static void changeSkin(Component comp, LookAndFeel laf) {
        try {
            UIManager.setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(mp3Player.class.getName()).log(Level.SEVERE, null, ex);
        }

        SwingUtilities.updateComponentTreeUI(comp);
        
    }
    
    public static void changeSkin(Component comp, String laf) {
        try {
            try {
                UIManager.setLookAndFeel(laf);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SkinUtils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(SkinUtils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(SkinUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(mp3Player.class.getName()).log(Level.SEVERE, null, ex);
        }

        SwingUtilities.updateComponentTreeUI(comp);
        
    }
}
