package me.dri.lojadodri.repositories;

import me.dri.lojadodri.models.ClienteLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface ClienteLoginRepository extends JpaRepository<ClienteLogin, Long> {


}
