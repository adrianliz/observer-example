import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

  void save(final User user);

  Optional<User> find(final UUID userId);
}
