public final class UserRegistrar {

  private final UserRepository userRepository;
  private final EmailNotifier emailNotifier;

  public UserRegistrar(InMemoryUserRepository userRepository, EmailNotifier emailNotifier) {
    this.userRepository = userRepository;
    this.emailNotifier = emailNotifier;
  }

  public void register(final User user) {
    userRepository.save(user);
    emailNotifier.sendRegistrationEmailTo(user);
  }
}
