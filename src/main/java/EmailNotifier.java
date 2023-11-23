public final class EmailNotifier {

  public void newUserRegistered(final User user) {
    System.out.println("Sending email to " + user);
  }
}
