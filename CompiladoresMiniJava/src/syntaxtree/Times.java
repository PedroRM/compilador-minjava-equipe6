package syntaxtree;
import symbol.Symbol;
import translate.TreeIRVisitor;
import translate.VisitorIR;
import typechecking.TypeCheckVisitor;
import visitor.Visitor;
import visitor.TypeVisitor;

public class Times extends Exp {
  public Exp e1,e2;
  
  public Times(Exp ae1, Exp ae2) {
    e1=ae1; e2=ae2;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Type accept(TypeVisitor v) {
    return v.visit(this);
  }
  
  public Symbol accept(TypeCheckVisitor v) {
		return v.visit(this);
		// TODO Auto-generated method stub
		
}

@Override
public translate.Exp accept(VisitorIR v) {
	// TODO Auto-generated method stub
	return v.visit(this);
}
}
