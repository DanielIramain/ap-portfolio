package com.myportfolio.ddi.Interface;

import com.myportfolio.ddi.Entity.Person;
import java.util.List;

public interface IPersonService {
    // Interface (CRUD) => Service
    
    //Devuelve una lista de personas
    public List<Person> getPerson();
    
    //Guarda un objeto de tipo Person
    public void savePerson(Person person);
    
    //Elimina un objeto (por id)
    public void deletePerson(Long id);
    
    //Busca un objeto persona (por id)
    public Person findPerson(Long id);
}
