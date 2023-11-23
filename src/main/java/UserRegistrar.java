public final class UserRegistrar {

  private final UserRepository userRepository;
  private final EmailNotifier emailNotifier;
  private final SlackNotifier slackNotifier;

  public UserRegistrar(
      InMemoryUserRepository userRepository,
      EmailNotifier emailNotifier,
      SlackNotifier slackNotifier) {
    this.userRepository = userRepository;
    this.emailNotifier = emailNotifier;
    this.slackNotifier = slackNotifier;
  }

  public void register(final User user) {
    userRepository.save(user);
    emailNotifier.sendRegistrationEmailTo(user);
    slackNotifier.sendNotificationTo(user);
  }
}
