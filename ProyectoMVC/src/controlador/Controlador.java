package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.Vista;

public class Controlador implements ActionListener {

    private final Vista view;
    private final Modelo model;

    public Controlador(Vista view, Modelo model) {
        this.view = view;
        this.model = model;

        // Escuchadores de botones
        this.view.btnSumar.addActionListener(this);
        this.view.btnRestar.addActionListener(this);
        this.view.btnMultiplicar.addActionListener(this);
        this.view.btnDividir.addActionListener(this);
    }

    public void iniciar() {
        view.setTitle("MVC CALCULADORA");
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Obtener valores de la vista
        model.setNumeroUno(Integer.parseInt(view.txtNumeroUno.getText()));
        model.setNumeroDos(Integer.parseInt(view.txtNumeroDos.getText()));

        // Detectar botón pulsado
        if (e.getSource() == view.btnSumar) {
            model.sumar();
        } 
        else if (e.getSource() == view.btnRestar) {
            model.restar();
        } 
        else if (e.getSource() == view.btnMultiplicar) {
            model.multiplicar();
        } 
        else if (e.getSource() == view.btnDividir) {
            model.dividir(); // si es 0, no hace nada
        }

        // Mostrar resultado
        view.txtResultado.setText(String.valueOf(model.getResultado()));
    }
}