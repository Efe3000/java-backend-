package be.ucll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.ucll.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>{
    
@Override
default <S extends Profile> S save(S entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'save'");
}




}
