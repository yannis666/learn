package fsm;

public class FSMTester {
  interface FSM<A, B> {
    A getCurrentState();

    A transition(B impetus);

    void go();
  }

  enum State {
    INITIAL, STARTING, RUNNING, FAILING, FAILED, STOPPING, STOPPED
  }

  enum Impetus {
    GO,
    FAIL,
    STOP
  }


}
