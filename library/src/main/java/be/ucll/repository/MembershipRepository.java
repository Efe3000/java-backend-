package be.ucll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.ucll.model.Membership;
import be.ucll.model.User;


public interface MembershipRepository extends  JpaRepository<Membership, Long> {
// @Override
// default <S extends Membership> S save(S entity) {
//     // TODO Auto-generated method stub
//     throw new UnsupportedOperationException("Unimplemented method 'save'");
// }

   List<Membership> findByUser(User user);
   


}
