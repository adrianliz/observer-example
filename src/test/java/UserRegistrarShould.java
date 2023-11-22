import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public final class UserRegistrarShould {

  @Test
  public void register_user() {
    var userId = UUID.randomUUID();
    var user = new User(userId, "user1@email.com");
    var userRepository = new InMemoryUserRepository();
    var emailNotifier = new EmailNotifier();
    var userRegistrar = new UserRegistrar(userRepository, emailNotifier);

    userRegistrar.register(user);

    Assertions.assertThat(userRepository.find(userId)).contains(user);
  }

  @Test
  public void send_mail_to_user_after_registration() {
    var userId = UUID.randomUUID();
    var user = new User(userId, "user1@email.com");
    var userRepository = new InMemoryUserRepository();
    var emailNotifier = spy(new EmailNotifier());
    var userRegistrar = new UserRegistrar(userRepository, emailNotifier);

    userRegistrar.register(user);

    verify(emailNotifier).sendRegistrationEmailTo(user);
  }
}
