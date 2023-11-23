public final class UserRegistrar {

  private final UserRepository userRepository;
  private final EmailNotifier emailNotifier;
  private final SlackNotifier slackNotifier;
  private final UserCounter userCounter;

  public UserRegistrar(
      InMemoryUserRepository userRepository,
      EmailNotifier emailNotifier,
      SlackNotifier slackNotifier,
      UserCounter userCounter) {
    this.userRepository = userRepository;
    this.emailNotifier = emailNotifier;
    this.slackNotifier = slackNotifier;
    this.userCounter = userCounter;
  }

  public void register(final User user) {
    userRepository.save(user);
    emailNotifier.sendRegistrationEmailTo(user);
    slackNotifier.sendNotificationTo(user);
    userCounter.increment();
  }
}
