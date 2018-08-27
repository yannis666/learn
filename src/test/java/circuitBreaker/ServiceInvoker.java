package circuitBreaker;

public interface ServiceInvoker {
  enum Result {
    transmitted,
    error,
  }

  Result invokeService();
}
