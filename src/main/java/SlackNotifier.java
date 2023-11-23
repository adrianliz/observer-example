public final class SlackNotifier implements UserRegisteredSubscriber {

  public void newUserRegistered(User user) {
    System.out.println("Sending Slack notification to " + user);
  }
}
