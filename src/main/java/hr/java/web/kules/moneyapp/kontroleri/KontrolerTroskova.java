package hr.java.web.kules.moneyapp.kontroleri;

import hr.java.web.kules.moneyapp.entiteti.Expense;
import hr.java.web.kules.moneyapp.entiteti.Novcanik;
import hr.java.web.kules.moneyapp.entiteti.Vrsta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;



@SessionAttributes ({"Vrste", "novcanik"})
@Controller

public class KontrolerTroskova
{
    Logger log = LoggerFactory.getLogger(KontrolerTroskova.class);

    @ModelAttribute ("novcanik")
    public Novcanik stvoriNovcanik()
    {
       log.info("Stvaram novcanik");
        return new Novcanik();
    }

    @GetMapping ("/moneyapp")
    public String prikaziFormu(Model model)
    {
        //log.info("Prikazujem formu");
        model.addAttribute("expense", new Expense());
        model.addAttribute("Vrste", Vrsta.values());
        return "UnosTroska";
    }

    @PostMapping ("/moneyapp")
    public String prihvatiFormu( Novcanik novcanik, @Validated Expense trosak, Errors errors, Model model)
    {
        log.info("prihvacam formu");
        if(errors.hasErrors())
        {
            return "UnosTroska";
        }
        novcanik.getPopis().add(trosak);
        Double suma=0.0;
        for (Expense expense: novcanik.getPopis())
        {
            suma+=expense.getIznos();
        }
        model.addAttribute("Trosak", trosak);
        model.addAttribute("Stanje", suma);
        return "IspisTroska";
    }


    @GetMapping ("/uplata")
    public String uplati(Model model)
    {
        log.info("Prikazujem formu");
        model.addAttribute("expense", new Expense());
        model.addAttribute("Vrste", Vrsta.values());
        return "UplataUNovcanik";
    }

    @PostMapping ("/uplata")
    public String unesiUplatu( Novcanik novcanik, @Validated Expense trosak, Errors errors, Model model)
    {
        log.info("prihvacam formu");
        if(errors.hasErrors())
        {
            return "UplataUNovcanik";
        }
        novcanik.getPopis().remove(trosak);
        Double suma=0.0;
        for (Expense expense: novcanik.getPopis())
        {
            suma+=expense.getIznos();
        }
        model.addAttribute("Trosak", trosak);
        model.addAttribute("Stanje", suma);
        return "IspisTroska";
    }

    @GetMapping("/resetirajNovcanik")
    @Secured("ROLE_ADMIN")
    public String resetNovcanik(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        //log.info("Resetiram sesiju");
        return "redirect:/moneyapp";
    }
    @Secured ("ROLE_ADMIN")
    @GetMapping ("/adminpage")
    public String adminPage()
    {

        return "AdminPage";
    }
}
