
package com.myportfolio.ddi.Repository;

import com.myportfolio.ddi.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {
    
}
