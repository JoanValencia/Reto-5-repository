/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.JFrame;

/**
 *
 * @author gefry
 */
public class MainWindow extends JFrame {
    
    public MainWindow(){
        initComponents();
    }
    
    private void initComponents(){
        
        setTitle("Tienda de Películas");
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = getSize();
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        OptionsPanel optionsPanel = new OptionsPanel();
        ResultsPanel resultsPanel = new ResultsPanel();
        InputPanel inputPanel = new InputPanel();

        add(optionsPanel, BorderLayout.LINE_START);
        add(inputPanel, BorderLayout.LINE_END);
        add(resultsPanel, BorderLayout.PAGE_END);
        
        
        pack();
        //setSize(1040, 720);
        
        setLocation((screenSize.width  - frameSize.width)  / 2, 
                    (screenSize.height - frameSize.height) / 2);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
