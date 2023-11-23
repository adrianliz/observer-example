public final class EmailNotifier implements UserRegisteredSubscriber {

  @Override
  public void newUserRegistered(final User user) {
    System.out.println("Sending email to " + user);
  }
}
