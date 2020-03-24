package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.cgi.dentistapp.util.DateTimeUtil.validateNew;

@Controller
@EnableAutoConfiguration
@RequestMapping("/")
public class DentistAppController implements WebMvcConfigurer {

    // Don't need @Autowired if class has only one constructor. Field injection not recommended also
    private DentistVisitService dentistVisitService;

    public DentistAppController(DentistVisitService dentistVisitService) {
        this.dentistVisitService = dentistVisitService;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showRegisterForm(DentistVisitEntity dentistVisitEntity, Model model) {
        model.addAttribute("dentists", getDentists());
        return "form";
    }

    @GetMapping("/registrations")
    public String showAllRegistrations(Model model) {
        model.addAttribute("visits", dentistVisitService.getAll());
        return "registrations";
    }

    @GetMapping("/search")
    public String searchVisit(@RequestParam String dentistName, Model model) {
        model.addAttribute("visits", dentistVisitService.search(dentistName));
        return "registrations";
    }

    @GetMapping("/registrations/{id}")
    public String viewRegistration (@PathVariable("id") Long id, Model model) {
        model.addAttribute(dentistVisitService.get(id));
        return "view";
    }

    public List<String> getDentists() {
        return new ArrayList<String>(Arrays.asList("Tiina Laurits", "Helena Laar", "Tiiu Parn", "Madis Laht", "Rudolf Mark", "Ain Kallas"));
    }

    @PostMapping("/delete")
    public String deleteVisit(@RequestParam("id") long id, RedirectAttributes redirectAttributes) {
        dentistVisitService.delete(id);
        redirectAttributes.addFlashAttribute("message", "message");
        return "redirect:/registrations";
    }

    @PostMapping("/update")
    public String updateVisit(@RequestParam("id") long id, Model model) {
        DentistVisitEntity dentistVisitEntity = dentistVisitService.get(id);
        model.addAttribute("dentistVisitEntity", dentistVisitEntity);
        model.addAttribute("dentists", getDentists());
        return "form";
    }

    @PostMapping("/save")
    public String postRegisterForm(@Valid DentistVisitEntity dentistVisitEntity, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dentists", getDentists());
            return "form";
        }
        // plus and minus hours are for checking visits if date changes
        List<DentistVisitEntity> existing = dentistVisitService.findByDateBetween(
                dentistVisitEntity.getVisitDateTime().minusHours(25),
                dentistVisitEntity.getVisitDateTime().plusHours(25),
                dentistVisitEntity.getDentistName());

        if(validateNew(dentistVisitEntity, existing)) {
            model.addAttribute("dentists", getDentists());
            bindingResult.rejectValue("visitDateTime", "error.visitDateTime", "Antud aeg ja kuupäev on sellel hambaarstil kinni! Provige valida teist aega või hambaarsti");
            return "form";
        }
        dentistVisitService.create(dentistVisitEntity);
        return "redirect:/results";
    }
}
