/**
 * Created by yx on 9/9/16.
 */
public class GreedyNode {
    int currentState;
    Action previousAction;
    int previousState;
    int depth;

    public GreedyNode(int currentState, Action previousAction, int previousState, int depth) {
        this.currentState = currentState;
        this.previousAction = previousAction;
        this.previousState = previousState;
        this.depth = depth;
    }

    int getCurrentState() {
        return this.currentState;
    }

    int getPreviousState() {
        return this.previousState;
    }

    Action getPreviousAction() {
        return this.previousAction;
    }

    int getDepth() {
        return this.depth;
    }
}
