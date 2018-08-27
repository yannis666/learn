package circuitBreaker;

import javax.inject.Inject;

public class CircuitBreakerImpl implements CircuitBreaker {
  private final ServiceInvoker invoker;
  private States state = States.CLOSED;

  @Inject
  CircuitBreakerImpl(ServiceInvoker invoker) {
    this.invoker = invoker;
  }


  @Override
  public Result invokeService() {
    switch (state) {
      case OPEN:
        return Result.error;
      case CLOSED:
        return invokeServiceInner();
      case HALF_OPEN:
        return invokeHalfOpen();
      default:
        throw new IllegalStateException();
    }
  }

  private Result invokeHalfOpen() {
    return null;
  }

  private Result invokeServiceInner() {
    try {
      Result result = invoker.invokeService();
      return result;
    } catch (RuntimeException e) {
      setFailing();
      return Result.error;
    }
  }

  private void setFailing() {
    state = States.OPEN;
  }


}
