import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public final class InMemoryUserRepository implements UserRepository {
  private final Map<UUID, User> users;

  public InMemoryUserRepository() {
    this.users = new HashMap<>();
  }

  @Override
  public void save(final User user) {
    users.put(user.getId(), user);
  }

  @Override
  public Optional<User> find(final UUID userId) {
    return Optional.ofNullable(users.get(userId));
  }
}
