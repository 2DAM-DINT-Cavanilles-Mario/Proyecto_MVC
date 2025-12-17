/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author martorarm
 */
public class Controlador implements ActionListener {
    private final Vista view;
    private final Modelo model;
    
    public Controlador(Vista view, Modelo model) {
        this.view = view;
        this.model = model;
        
        this.view.btnMultiplicar.addActionListener(this);
    }
    
    public void iniciar() {
        view.setTitle("MVC MULTIPLICAR");
        
        view.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        model.setNumeroUno(Integer.parseInt(view.txtNumeroUno.getText()));
        model.setNumeroDos(Integer.parseInt(view.txtNumeroDos.getText()));
        
        model.multiplicar();
        
        view.txtResultado.setText(String.valueOf(model.getResultado()));
    }
}
