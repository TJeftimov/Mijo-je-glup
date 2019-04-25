package hr.java.web.kules.moneyapp.entiteti;

import java.util.ArrayList;

public class Novcanik {
    private String nazivNovcanika;
    private Tip tip;
    private ArrayList<Expense> popis;

    public String getNazivNovcanika() {
        return nazivNovcanika;
    }

    public void setNazivNovcanika(String nazivNovcanika) {
        this.nazivNovcanika = nazivNovcanika;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public ArrayList<Expense> getPopis() {
        return popis;
    }

    public void setPopis(ArrayList<Expense> popis) {
        this.popis = popis;
    }

    public Novcanik()
    {
        this.popis=new ArrayList<Expense>();
    }


    public enum Tip {KOZNI, PLATNENI, TRAPER};

}
