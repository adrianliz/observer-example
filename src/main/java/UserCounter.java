public final class UserCounter {

  private int numberOfUsers;

  public UserCounter() {
    this.numberOfUsers = 0;
  }

  public void newUserRegistered(final User user) {
    System.out.println("Incrementing user count for " + user);
    increment();
  }

  private void increment() {
    numberOfUsers++;
  }

  public int count() {
    return numberOfUsers;
  }
}
