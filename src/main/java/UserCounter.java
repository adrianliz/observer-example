public final class UserCounter {

  private int numberOfUsers;

  public UserCounter() {
    this.numberOfUsers = 0;
  }

  public void increment() {
    numberOfUsers++;
  }

  public int count() {
    return numberOfUsers;
  }
}
