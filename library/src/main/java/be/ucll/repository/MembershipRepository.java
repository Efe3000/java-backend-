package be.ucll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.ucll.model.Membership;


public interface MembershipRepository extends  JpaRepository<Membership, Long> {
// @Override
// default <S extends Membership> S save(S entity) {
//     // TODO Auto-generated method stub
//     throw new UnsupportedOperationException("Unimplemented method 'save'");
// }




}
