
package com.myportfolio.ddi.Controller;

import com.myportfolio.ddi.Entity.Person;
import com.myportfolio.ddi.Interface.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//to fix Cros Policy
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonController {
    
    //La interfaz llama al servicio
    @Autowired IPersonService ipersonService;
    
    @GetMapping("person/bring")
    public List<Person> getPerson() {
        return ipersonService.getPerson();
    }
    
    //"Yo" en portafolio
    @GetMapping("person/bring/profile")
    public Person findPerson() {
        return ipersonService.findPerson((long)3);
    }
    
    @PostMapping("/person/create")
    public String createPerson(@RequestBody Person person) {
        ipersonService.savePerson(person);
        return "The person was created successfully";
    }
    
    @DeleteMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        ipersonService.deletePerson(id);
        return "The person was eliminated successfully";
    }
    
    @PutMapping("/person/edit/{id}")
    public Person editPerson(@PathVariable Long id,
                             @RequestParam("name") String newName,
                             @RequestParam("lastname") String newLastname,
                             @RequestParam("img") String newImg){
        Person person = ipersonService.findPerson(id);
        
        person.setName(newName);
        person.setLastname(newLastname);
        person.setImg(newImg);
        
        ipersonService.savePerson(person);
        return person;
    }
}
