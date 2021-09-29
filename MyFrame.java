package texteditor;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;


public class MyFrame extends JFrame {
   
    private JButton newBtn, openBtn, clearBtn, saveBtn, saveAsBtn, deleteBtn, 
                    statisticsBtn, exitBtn;
    
    private JTextArea area;
    private JTextField pathArea;
    private JScrollBar horizontalScroll,verticalScroll;
    
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem newItm, openItm, clearItm, saveItm, saveAsItm, deleteItm,
                      statisticsItm, exitItm;

    JFileChooser fc = new JFileChooser();
    
    FileNameExtensionFilter filter =
    new FileNameExtensionFilter("TEXT FILES", "txt", "text");
    
  public MyFrame() {
      
        fc.setFileFilter(filter);
        
        CreateUI();
        BtnFunctions();
        MenuItemsFunctions();
    }
  
  
    private void CreateUI() {
      
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        newBtn = new JButton("New");
        openBtn = new JButton("Open");
        clearBtn = new JButton("Clear");
        saveBtn = new JButton("Save");
        saveAsBtn = new JButton("SaveAS");
        deleteBtn = new JButton("Delete");
        statisticsBtn = new JButton("Statistics");
        exitBtn = new JButton("Exit");
        
        area = new JTextArea();
        pathArea = new JTextField();
        pathArea.setText(fc.getCurrentDirectory().getAbsolutePath());
        pathArea.setEditable(false);
        
        
        menuBar = new JMenuBar();
        verticalScroll = new JScrollBar();
        horizontalScroll = new JScrollBar();
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonsPanel.setBackground(Color.gray);
        buttonsPanel.add(newBtn);
        buttonsPanel.add(openBtn);
        buttonsPanel.add(clearBtn);
        buttonsPanel.add(saveBtn);
        buttonsPanel.add(saveAsBtn);
        buttonsPanel.add(deleteBtn);
        buttonsPanel.add(statisticsBtn);
        buttonsPanel.add(exitBtn);
        
        JScrollPane scroll = new JScrollPane ( area );
        scroll.setVerticalScrollBarPolicy
        ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        
        
        JMenu menu = new JMenu("MENU");
        
        newItm = new JMenuItem("New");
        openItm = new JMenuItem("Open");
        clearItm = new JMenuItem("Clear");
        saveItm = new JMenuItem("Save");
        saveAsItm = new JMenuItem("SaveAs");
        deleteItm = new JMenuItem("Delete");
        statisticsItm = new JMenuItem("Statistics");
        exitItm = new JMenuItem("Exit");
        
        menu.add(newItm);
        menu.add(openItm);
        menu.add(clearItm);
        menu.add(saveItm);
        menu.add(saveAsItm);
        menu.add(deleteItm);
        menu.add(statisticsItm);
        menu.add(exitItm);
        
        menuBar.add(menu);
        
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        menuPanel.add(menuBar, BorderLayout.NORTH);
        menuPanel.add(pathArea, BorderLayout.SOUTH);
        
        
        this.setLayout(new BorderLayout(10, 10));
        this.add(menuPanel,BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);
        

    }
    
    private void BtnFunctions() {
        //ONOMATA KAI DRASEIS TWN BUTTONS.
        
        newBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  area.setText("");
            }
        } );
        
        openBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fc.setCurrentDirectory(new java.io.File("."));
                fc.setDialogTitle("Please choose your file");
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                
                if(fc.showOpenDialog(openBtn) == JFileChooser.APPROVE_OPTION){
                    File f = fc.getSelectedFile();
                    String filePath = f.getAbsolutePath();
                    System.out.println("You Choose: " 
                    + fc.getSelectedFile().getAbsolutePath() 
                    + " file");
                    pathArea.setText(f.getAbsolutePath());
        try{  
        BufferedReader br = new BufferedReader(new FileReader(filePath));    
        String s1="",s2="";                        
        while((s1 = br.readLine()) != null){    
        s2+=s1+"\n";    
        }    
        area.setText(s2);    
        br.close();    
        }catch (Exception ex) {ex.printStackTrace();}
        }
       }
        } 
    );
        
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f = fc.getSelectedFile();
                area.setText("");
            }
        } );
        
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fc.setCurrentDirectory(new java.io.File("."));
                fc.setDialogTitle("Please save your file");
            if ( fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {  
  
                try { 
                    File f = fc.getSelectedFile();
                    FileWriter wr = new FileWriter(f, false);
                    BufferedWriter w = new BufferedWriter(wr); 
                    pathArea.setText(f.getAbsolutePath());
                    w.write(area.getText()); 
                    w.flush(); 
                    w.close(); 
                } 
                catch (Exception evt) { 
                    JOptionPane.showMessageDialog(fc, evt.getMessage()); 
                } 
            } 
            // If the user cancelled the operation 
            else
                JOptionPane.showMessageDialog(fc, 
                "the user cancelled the operation"); 
            }
        } );
        
        saveAsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            fc.setCurrentDirectory(new java.io.File("."));
            fc.setDialogTitle("Please save your file");
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
               PrintWriter fout = new PrintWriter(fc.getSelectedFile());
               fout.printf(area.getText().trim());
               fout.close();
           } catch (FileNotFoundException ex) {
           }
       }
       }
        } );
       
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            fc.setCurrentDirectory(new java.io.File("."));
            fc.setDialogTitle("Please choose your file");
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File f1 = fc.getSelectedFile();
             int input = JOptionPane.showConfirmDialog(null, 
                "Do you want to proceed?", "File deletion",
                JOptionPane.YES_NO_CANCEL_OPTION);
            if (input == 0) {
                f1.delete();
                area.setText("");
            }
            }
            }
            } );
        
        statisticsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f = fc.getSelectedFile();
                fc.setCurrentDirectory(f);
                String text=area.getText();  
                String words[]=text.split("\\s");
                long fSize = f.length();
                JOptionPane.showMessageDialog(fc,
                "Number of Words: " + words.length +
                "\nNumber of Characters(no blanks): " + (text.length() - words.length)  +
                "\nNumber of Characters(with blanks): " + text.length() +
                "\nTotal File Size: " + fSize + " Bytes" );
            }
        } );
        
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(null, 
                "Do you want to proceed?", "Exit TextEditor",
                JOptionPane.YES_NO_CANCEL_OPTION);
                if (input == 0) {
                    System.exit(0);
            }
            }
        } );
    }
    
    private void MenuItemsFunctions() {
        //ONOMATA KAI DRASEIS TWN STOIXIEWN TOU MENU.
        newItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f = fc.getSelectedFile();
                area.setText("");
            }
        } );
        
        openItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fc.setCurrentDirectory(new java.io.File("."));
                fc.setDialogTitle("Please choose your file");
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                
                if(fc.showOpenDialog(openItm) == JFileChooser.APPROVE_OPTION){
                    File f = fc.getSelectedFile();
                    String filePath = f.getAbsolutePath();
                    System.out.println("You Choose: " 
                    + fc.getSelectedFile().getAbsolutePath() 
                    + " file");
                    pathArea.setText(f.getAbsolutePath());
        try{  
        BufferedReader br = new BufferedReader(new FileReader(filePath));    
        String s1="",s2="";                        
        while((s1 = br.readLine()) != null){    
        s2+=s1+"\n";    
        }    
        area.setText(s2);    
        br.close();    
        }catch (Exception ex) {ex.printStackTrace();}
        }
       }
        } 
    );
        
        clearItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  area.setText("");
            }
        } );
        
        saveItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fc.setCurrentDirectory(new java.io.File("."));
                fc.setDialogTitle("Please save your file");
            if ( fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {  
  
                try { 
                    File f = fc.getSelectedFile();
                    FileWriter wr = new FileWriter(f, false);
                    BufferedWriter w = new BufferedWriter(wr); 
                    pathArea.setText(f.getAbsolutePath());
                    w.write(area.getText()); 
                    w.flush(); 
                    w.close(); 
                } 
                catch (Exception evt) { 
                    JOptionPane.showMessageDialog(fc, evt.getMessage()); 
                } 
            } 
            // If the user cancelled the operation 
            else
                JOptionPane.showMessageDialog(fc, 
                "the user cancelled the operation"); 
            }
        } );
        
        saveAsItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            fc.setCurrentDirectory(new java.io.File("."));
            fc.setDialogTitle("Please save your file");
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
               PrintWriter fout = new PrintWriter(fc.getSelectedFile());
               fout.printf(area.getText().trim());
               fout.close();
           } catch (FileNotFoundException ex) {
           }
       }
       }
        } );
       
        deleteItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            fc.setCurrentDirectory(new java.io.File("."));
            fc.setDialogTitle("Please choose your file");
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File f1 = fc.getSelectedFile();
             int input = JOptionPane.showConfirmDialog(null, 
                "Do you want to proceed?", "File deletion",
                JOptionPane.YES_NO_CANCEL_OPTION);
            if (input == 0) {
                f1.delete();
                area.setText("");
            }
            }
            }
            } );
        
        statisticsItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f = fc.getSelectedFile();
                fc.setCurrentDirectory(f);
                String text=area.getText();  
                String words[]=text.split("\\s");
                long fSize = f.length();
                JOptionPane.showMessageDialog(fc,
                "Number of Words: " + words.length +
                "\nNumber of Characters(no blanks): " + (text.length() - words.length)  +
                "\nNumber of Characters(with blanks): " + text.length() +
                "\nTotal File Size: " + fSize + " Bytes" );
            }
        } );
        
        exitItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(null, 
                "Do you want to proceed?", "Exit TextEditor",
                JOptionPane.YES_NO_CANCEL_OPTION);
                if (input == 0) {
                    System.exit(0);
            }
            }
        } );
    }
}