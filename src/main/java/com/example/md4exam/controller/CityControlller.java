package com.example.md4exam.controller;

import com.example.md4exam.model.City;
import com.example.md4exam.model.Country;
import com.example.md4exam.service.ICityService;
import com.example.md4exam.service.ICountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class CityControlller {
    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute("countries")
    public Iterable<Country> listCountry() {
        return countryService.findAll();
    }

    @GetMapping
    public String showCity(Model model){
        List<City> cities = cityService.findAll();
        model.addAttribute("cities",cities);
        return "view/home";
    }

    @GetMapping("/create")
    public String saveCity(Model model){
        model.addAttribute("city",new City());
        return "view/form";
    }

    @PostMapping("/create")
     public String saveCity(@Valid @ModelAttribute("city") City city,
                            Model model,
                            BindingResult bindingResult){
        if (!bindingResult.hasErrors()) {
            cityService.save(city);
            model.addAttribute("city",city);
            model.addAttribute("message", "New city created successfully");
            return "view/form";
        }
        model.addAttribute("message", "Có lỗi xảy ra, vui lòng kiểm tra lại thông tin");
        model.addAttribute("city",city);
        return "view/form";
    }

    @GetMapping("/update/{id}")
    public String showEditForm(@PathVariable Long id,
                               Model model) {
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()) {
            model.addAttribute("city", city.get());
            return "view/form";
        } else {
            return "error_404";
        }
    }

    @PostMapping("/update/{id}")
    public String updateCity(@PathVariable Long id,
                             @Valid @ModelAttribute("city") City updatedCity,
                             BindingResult bindingResult) {
        Optional<City> existingCity = cityService.findById(id);

        if (existingCity.isPresent()) {
            if (bindingResult.hasErrors()) {
                return "view/form";
            }
            updatedCity.setId(id);
            cityService.save(updatedCity);
        }
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteCity(@PathVariable Long id){
        cityService.remove(id);
        return "redirect:/home";
    }

    @GetMapping("/city/{id}")
    public String showGameDetail(@PathVariable("id") Long id,
                                 Model model) {
        Optional<City> cityOptional = cityService.findById(id);
        if (cityOptional.isPresent()) {
            model.addAttribute("city", cityOptional.get());
            return "view/city";
        }
        return "redirect:/home";
    }
}
