public final class SlackNotifier {

  public void newUserRegistered(User user) {
    System.out.println("Sending Slack notification to " + user);
  }
}
