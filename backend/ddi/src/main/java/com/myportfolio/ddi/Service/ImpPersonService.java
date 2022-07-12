package com.myportfolio.ddi.Service;

import com.myportfolio.ddi.Entity.Person;
import com.myportfolio.ddi.Interface.IPersonService;
import com.myportfolio.ddi.Repository.IPersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonService implements IPersonService {
    
    //Trae el repositorio para que lea los campos que tenemos
    //@Autowired TIPO, NOMBRE DE VARIABLE
    @Autowired IPersonRepository ipersonRepository;
    
    @Override
    public List<Person> getPerson() {
        List<Person> person = ipersonRepository.findAll();
        return person;
    }

    @Override
    public void savePerson(Person person) {
        ipersonRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        ipersonRepository.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
        Person person = ipersonRepository.findById(id).orElse(null);
        return person;
    }
    
}
