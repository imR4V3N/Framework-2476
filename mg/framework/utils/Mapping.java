package mg.framework.utils;
import java.util.ArrayList;
import java.util.List;

public class Mapping {
    String className;
    List<VerbAction> verbAction = new ArrayList<VerbAction>();

    public Mapping(){}
    public Mapping(String className) {
        this.className = className;
    }
    public Mapping(String className, List<VerbAction> verbAction) {
        this.className = className;
        this.verbAction = verbAction;
    }

    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public List<VerbAction> getVerbAction() {
        return verbAction;
    }
    public void setVerbAction(List<VerbAction> verbAction) {
        this.verbAction = verbAction;
    }

    public void addVerbAction(VerbAction verbAction) {
        this.verbAction.add(verbAction);
    }
}