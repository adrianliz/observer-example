import java.util.Set;

public final class UserRegistrar {

  private final UserRepository userRepository;
  private final Set<UserRegisteredSubscriber> subscribers;

  public UserRegistrar(
      final InMemoryUserRepository userRepository,
      final Set<UserRegisteredSubscriber> subscribers) {
    this.userRepository = userRepository;
    this.subscribers = subscribers;
  }

  public void register(final User user) {
    userRepository.save(user);
    subscribers.forEach(subscriber -> subscriber.newUserRegistered(user));
  }
}
