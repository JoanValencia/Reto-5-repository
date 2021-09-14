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
        
        setTitle("Administrador de Películas");
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = getSize();
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        InputPanel inputPanel = new InputPanel();
        ResultsPanel resultsPanel = new ResultsPanel(inputPanel);
        OptionsPanel optionsPanel = new OptionsPanel(inputPanel, resultsPanel);
        optionsPanel.setBorder(BorderFactory.createTitledBorder("Seleccione"));
        
        inputPanel.setBorder(BorderFactory.createTitledBorder("Ingresar Información / Detalle"));
        resultsPanel.setBorder(BorderFactory.createTitledBorder("Tabla Actualizada de Películas"));
        
        add(optionsPanel, BorderLayout.LINE_START);
        add(inputPanel, BorderLayout.CENTER);
        add(resultsPanel, BorderLayout.PAGE_END);
                
        pack();
        //setSize(1040, 720);
        
        setLocation((screenSize.width  - frameSize.width)  / 4, 
                    (screenSize.height - frameSize.height) / 4);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
