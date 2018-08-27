package circuitBreaker;

public interface CircuitBreaker extends ServiceInvoker {
  enum States {
    CLOSED,
    OPEN,
    HALF_OPEN
  }
}
