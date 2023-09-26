package med.voll.api.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
/*
 * Permite a interação com o banco de dados de forma simples e eficiente, sem a necessidade de escrever consultas SQL manualmente
 * 
 * Essa interface serve como uma "ponte" entre o código da aplicação e o banco de dados. 
 * Podemos realizar operações de CRUD (Create, Read, Update, Delete) sem a necessidade de escrever consultas SQL manualmente.
 * 
 * JPARepository precisa de dois parâmetors => Chave primária(entidade) e o identificador(Long (que é o ID neste caso))
 * 
 */

public interface DoctorRepository extends JpaRepository<DoctorSchema, Long> {

}
