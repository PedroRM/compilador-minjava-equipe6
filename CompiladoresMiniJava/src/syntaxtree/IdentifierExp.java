package syntaxtree;
import symbol.Symbol;
import translate.VisitorIR;
import typechecking.TypeCheckVisitor;
import visitor.Visitor;
import visitor.TypeVisitor;

public class IdentifierExp extends Exp {
  public String s;
  public IdentifierExp(String as) { 
    s=as;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Type accept(TypeVisitor v) {
    return v.visit(this);
  }
  
  public String toString ()
  {
	  return s;
  }
  
  public Symbol accept(TypeCheckVisitor v) {
		return v.visit(this);
		// TODO Auto-generated method stub
		
  }
  
  public translate.Exp accept(VisitorIR v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}
}
