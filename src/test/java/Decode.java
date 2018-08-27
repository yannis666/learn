import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class Decode {
  @Test
  public void doIt() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    Foo a = mapper.readValue("{\"k1\": \"v1\", \"k2\": \"v2\"}", Foo.class);
    System.out.println(a);
  }

  public static class Foo {
    private String k1 = null;
    private String k2 = null;


    public String getK1() {
      return k1;
    }

    public void setK1(String k1) {
      this.k1 = k1;
    }

    public String getK2() {
      return k2;
    }

    public void setK2(String k2) {
      this.k2 = k2;
    }

  }
}
