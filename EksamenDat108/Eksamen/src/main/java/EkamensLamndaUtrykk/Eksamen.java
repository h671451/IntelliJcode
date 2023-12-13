package EkamensLamndaUtrykk;

import java.time.LocalDate;

public class Eksamen {
    private String emnekode;
    private LocalDate dato;
    private int antallOppmeldte;

    public Eksamen(String emnekode, LocalDate dato, int antallOppmeldte) {
        this.emnekode = emnekode;
        this.dato = dato;
        this.antallOppmeldte = antallOppmeldte;
    }

    public String getEmnekode() {
        return emnekode;
    }

    public void setEmnekode(String emnekode) {
        this.emnekode = emnekode;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public int getAntallOppmeldte() {
        return antallOppmeldte;
    }

    public void setAntallOppmeldte(int antallOppmeldte) {
        this.antallOppmeldte = antallOppmeldte;
    }

    @Override
    public String toString() {
        return "Eksamen{" +
                "emnekode='" + emnekode + '\'' +
                ", dato=" + dato +
                ", antallOppmeldte=" + antallOppmeldte +
                '}';
    }
}
