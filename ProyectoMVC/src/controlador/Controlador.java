package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Modelo;
import vista.Vista;

public class Controlador implements ActionListener {

    private final Vista view;
    private final Modelo model;

    public Controlador(Vista view, Modelo model) {
        this.view = view;
        this.model = model;

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

        // ERROR: campos vacíos
        if (view.txtNumeroUno.getText().isEmpty() || view.txtNumeroDos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                view,
                "Debes introducir números en ambos campos",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Pasar datos al modelo
        model.setNumeroUno(Integer.parseInt(view.txtNumeroUno.getText()));
        model.setNumeroDos(Integer.parseInt(view.txtNumeroDos.getText()));

        // Operaciones
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

            // ERROR: dividir entre cero
            if (model.getNumeroDos() == 0) {
                JOptionPane.showMessageDialog(
                    view,
                    "No se puede dividir entre 0",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            model.dividir();
        }

        // Mostrar resultado
        view.txtResultado.setText(String.valueOf(model.getResultado()));
    }
}