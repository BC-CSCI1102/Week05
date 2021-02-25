public class DynExample {

  private int age;

  public DynExample(int age) {
    this.age = age;
  }

  private int getAge() {
    return this.age;
  }

  private void checkAge() {
    if (this.age < 0 || this.age > 120)
      throw new RuntimeException("Bad age");
  }

  public static void main(String[] args) {
    DynExample de = new DynExample(21);
    de.checkAge();
    System.out.format("Age is %d.\n", de.getAge());
  }
}



