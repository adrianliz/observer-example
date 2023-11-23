import java.util.Set;

public final class UserRegistrar {

  private final UserRepository userRepository;
  private final Set<UserRegisteredSubscriber> subscribers;

  public UserRegistrar(
      InMemoryUserRepository userRepository,
      EmailNotifier emailNotifier,
      SlackNotifier slackNotifier,
      UserCounter userCounter) {
    this.userRepository = userRepository;
    this.subscribers = Set.of(emailNotifier, slackNotifier, userCounter);
  }

  public void register(final User user) {
    userRepository.save(user);
    subscribers.forEach(subscriber -> subscriber.newUserRegistered(user));
  }
}
