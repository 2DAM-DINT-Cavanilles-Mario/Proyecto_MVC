package modelo;

public class Modelo {

    private int numeroUno;
    private int numeroDos;
    private int resultado;

    public int getNumeroUno() {
        return numeroUno;
    }

    public void setNumeroUno(int numeroUno) {
        this.numeroUno = numeroUno;
    }

    public int getNumeroDos() {
        return numeroDos;
    }

    public void setNumeroDos(int numeroDos) {
        this.numeroDos = numeroDos;
    }

    public int getResultado() {
        return resultado;
    }

    // SUMAR
    public int sumar() {
        resultado = numeroUno + numeroDos;
        return resultado;
    }

    // RESTAR
    public int restar() {
        resultado = numeroUno - numeroDos;
        return resultado;
    }

    // MULTIPLICAR
    public int multiplicar() {
        resultado = numeroUno * numeroDos;
        return resultado;
    }

    // DIVIDIR (NO divide entre 0)
    public int dividir() {
        if (numeroDos != 0) {
            resultado = numeroUno / numeroDos;
        }
        return resultado;
    }
}