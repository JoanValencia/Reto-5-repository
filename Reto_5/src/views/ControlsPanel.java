/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

//import controller.ChangeEvent;
//import controller.ClickEvent;
//import controller.InitialData;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.PeliculaModel;

/**
 *
 * @author gefry
 */
public class ControlsPanel extends JPanel{
    
    private JLabel lblMuseums;
    private JComboBox<PeliculaModel> cbxPeliculasList;
    private JLabel lblPresentations;
    private JLabel lblName;
    private JTextField txtName;
    private JButton btnSearch;
    private JButton btnAddArtPiece;
    private JTable tblResults;
    
    public ControlsPanel(ResultsPanel resultsPanel){
        //this.tblResults = resultsPanel.getTblResults();
        //initComponents();
    }
}

