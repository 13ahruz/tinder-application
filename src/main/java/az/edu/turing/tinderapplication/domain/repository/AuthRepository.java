package az.edu.turing.tinderapplication.domain.repository;

public interface AuthRepository {

    boolean authenticate (String username, String password);

}
