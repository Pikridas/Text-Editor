package texteditor;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

public class MyWindowListener implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int input = JOptionPane.showConfirmDialog(null, 
                "Do you want to proceed?", "Exit TextEditor",
                JOptionPane.YES_NO_CANCEL_OPTION);
                if (input == 0) {
                    System.exit(0);
                }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
         
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
 
}