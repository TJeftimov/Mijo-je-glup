package hr.java.web.kules.moneyapp.entiteti;



import lombok.Data;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class Expense {


    @NotEmpty(message = "Niste unijeli naziv")
    @Size(min=1, max=35, message = "Uneseni naziv nije u rasponu od 1-35 znakova")
    private String naziv;
    @NotNull(message = "Niste unijeli iznos")
    @DecimalMin(value = "1.01", message = "Unesli ste premali iznos")
    private Double iznos;

    @NotNull (message = "Niste odabrali vrstu.")
    private Vrsta vrsta;

    public String getNaziv() {
        return naziv;
    }

    public Double getIznos() {
        return iznos;
    }



    public Vrsta getVrsta() {
        return vrsta;
    }


}
