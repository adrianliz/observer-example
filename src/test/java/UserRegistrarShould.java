import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.Set;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public final class UserRegistrarShould {

  @Test
  public void register_user() {
    var userId = UUID.randomUUID();
    var user = new User(userId, "user1@email.com");
    var userRepository = new InMemoryUserRepository();
    var userRegistrar =
        new UserRegistrar(
            userRepository, Set.of(new EmailNotifier(), new SlackNotifier(), new UserCounter()));

    userRegistrar.register(user);

    Assertions.assertThat(userRepository.find(userId)).contains(user);
  }

  @Test
  public void send_mail_to_user_after_registration() {
    var userId = UUID.randomUUID();
    var user = new User(userId, "user1@email.com");
    var userRepository = new InMemoryUserRepository();
    var emailNotifier = spy(new EmailNotifier());
    var userRegistrar =
        new UserRegistrar(
            userRepository, Set.of(emailNotifier, new SlackNotifier(), new UserCounter()));

    userRegistrar.register(user);

    verify(emailNotifier).newUserRegistered(user);
  }

  @Test
  public void send_slack_notification_after_user_registration() {
    var userId = UUID.randomUUID();
    var user = new User(userId, "user1@gmail.com");
    var userRepository = new InMemoryUserRepository();
    var slackNotifier = spy(new SlackNotifier());
    var userRegistrar =
        new UserRegistrar(
            userRepository, Set.of(new EmailNotifier(), slackNotifier, new UserCounter()));

    userRegistrar.register(user);

    verify(slackNotifier).newUserRegistered(user);
  }

  @Test
  public void increment_number_of_user_after_user_registration() {
    var userId = UUID.randomUUID();
    var user = new User(userId, "user1@gmail.com");
    var userRepository = new InMemoryUserRepository();
    var userCounter = new UserCounter();
    var userRegistrar =
        new UserRegistrar(
            userRepository, Set.of(new EmailNotifier(), new SlackNotifier(), userCounter));

    userRegistrar.register(user);

    Assertions.assertThat(userCounter.count()).isEqualTo(1);
  }
}
