package ProjectBackEnd.backend.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjectBackEnd.backend.Model.AddOns;
import ProjectBackEnd.backend.NotFoundException.AddOnsNotFoundException;
import ProjectBackEnd.backend.Repository.AddonsRepository;

@RestController
@RequestMapping("/api/v1")
public class AddOnsController {

    AddonsRepository repo;

    public AddOnsController(AddonsRepository repo){
        this.repo = repo;
    }

    @PostMapping("/addons/new")
    public String addAddOns(@RequestBody AddOns newAddOns){
        repo.save(newAddOns);
        return "A new Add Ons has been added";
    }

    @GetMapping("/addons/{id}")
    public AddOns getAddOns(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new AddOnsNotFoundException(id));
    }

}

