import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public final class UserRegistrarShould {

  @Test
  public void register_user() {
    var userId = UUID.randomUUID();
    var user = new User(userId, "user1@email.com");
    var userRepository = new InMemoryUserRepository();
    var userRegistrar = new UserRegistrar(userRepository);

    userRegistrar.register(user);

    Assertions.assertThat(userRepository.find(userId)).contains(user);
  }
}
