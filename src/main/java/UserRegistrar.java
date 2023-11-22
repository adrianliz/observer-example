public final class UserRegistrar {

  private UserRepository userRepository;

  public UserRegistrar(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void register(final User user) {
    userRepository.save(user);
  }
}
