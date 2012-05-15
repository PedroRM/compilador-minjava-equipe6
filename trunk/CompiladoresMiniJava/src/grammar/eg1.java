/* Generated By:JavaCC: Do not edit this line. eg1.java */
package grammar;
import syntaxtree.*;
import visitor.*;
import symboltablevisitor.*;
import table.*;
import typechecking.*;
public class eg1 implements eg1Constants {
  public static void main(String[] args) throws ParseException
  {
    //System.out.println("TESTE");
        eg1 Analyzer  = new eg1(System.in);
        Program x = Analyzer.Start();
        Table k = x.accept(new ImperativeSymbolTableVisitor());
        System.out.println(k.toString());
        ConcreteTypeCheckVisitor j = new ConcreteTypeCheckVisitor();
        j.visit(x);

  }

  final public Program Start() throws ParseException {
 Program retorno;
    retorno = Program();
    jj_consume_token(42);
    System.out.println("Successfully recognized all tokens");
    {if (true) return retorno;}
    throw new Error("Missing return statement in function");
  }

  final public Program Program() throws ParseException {
  MainClass mainClass;
  ClassDecl classDecl;
  ClassDeclList cdList = new ClassDeclList();
    mainClass = MainClass();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CLASS:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      classDecl = ClassDecl();
                                     cdList.addElement(classDecl);
    }
             {if (true) return new Program(mainClass,cdList);}
    throw new Error("Missing return statement in function");
  }

  final public MainClass MainClass() throws ParseException {
  Statement statement;
  Token classId;
  Token stringId;
    jj_consume_token(CLASS);
    classId = jj_consume_token(ID);
    jj_consume_token(LBRACE);
    jj_consume_token(PUBLIC);
    jj_consume_token(STATIC);
    jj_consume_token(VOID);
    jj_consume_token(MAIN);
    jj_consume_token(LPAREN);
    jj_consume_token(STRING);
    jj_consume_token(LSQPAREN);
    jj_consume_token(RSQPAREN);
    stringId = jj_consume_token(ID);
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    statement = Statement();
    jj_consume_token(RBRACE);
    jj_consume_token(RBRACE);
    {if (true) return new MainClass(new Identifier(classId.toString()),new Identifier(stringId.toString()),statement);}
    throw new Error("Missing return statement in function");
  }

  final public ClassDecl ClassDecl() throws ParseException {
  Token classId;
  Token superClassId;
  MethodDeclList methodDeclList = new MethodDeclList();
  VarDeclList varDeclList = new VarDeclList();
  VarDecl varDecl;
  MethodDecl methodDecl;
    jj_consume_token(CLASS);
    classId = jj_consume_token(ID);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACE:
      jj_consume_token(LBRACE);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case BOOLEAN:
        case INTEGER:
        case ID:
          ;
          break;
        default:
          jj_la1[1] = jj_gen;
          break label_2;
        }
        varDecl = VarDecl();
                                                                        varDeclList.addElement(varDecl);
      }
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PUBLIC:
          ;
          break;
        default:
          jj_la1[2] = jj_gen;
          break label_3;
        }
        methodDecl = MethodDecl();
           methodDeclList.addElement(methodDecl);
      }
      jj_consume_token(RBRACE);
            {if (true) return new ClassDeclSimple(new Identifier(classId.toString()), varDeclList, methodDeclList);}
      break;
    case EXTENDS:
      jj_consume_token(EXTENDS);
      superClassId = jj_consume_token(ID);
      jj_consume_token(LBRACE);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case BOOLEAN:
        case INTEGER:
        case ID:
          ;
          break;
        default:
          jj_la1[3] = jj_gen;
          break label_4;
        }
        varDecl = VarDecl();
          varDeclList.addElement(varDecl);
      }
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PUBLIC:
          ;
          break;
        default:
          jj_la1[4] = jj_gen;
          break label_5;
        }
        methodDecl = MethodDecl();
          methodDeclList.addElement(methodDecl);
      }
      jj_consume_token(RBRACE);
          {if (true) return new ClassDeclExtends(new Identifier(classId.toString()), new Identifier(superClassId.toString()), varDeclList, methodDeclList);}
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public VarDecl VarDecl() throws ParseException {
  Token varID;
  Type type1;
    type1 = Type();
    varID = jj_consume_token(ID);
    jj_consume_token(SEMICOLON);
    {if (true) return new VarDecl(type1,new Identifier(varID.toString()));}
    throw new Error("Missing return statement in function");
  }

  final public MethodDecl MethodDecl() throws ParseException {
  Type t;
  Token methodID;
  FormalList fl;
  VarDeclList vl = new VarDeclList();
  StatementList sl = new StatementList();
  Exp e;
  VarDecl varDecl;
  Statement statement;
    jj_consume_token(PUBLIC);
    t = Type();
    methodID = jj_consume_token(ID);
    jj_consume_token(LPAREN);
    fl = FormalList();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    label_6:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_6;
      }
      varDecl = VarDecl();
           vl.addElement(varDecl);
    }
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRACE:
      case IF:
      case WHILE:
      case PRINT:
      case ID:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_7;
      }
      statement = Statement();
            sl.addElement(statement);
    }
    jj_consume_token(RETURN);
    e = Exp();
    jj_consume_token(SEMICOLON);
    jj_consume_token(RBRACE);
         {if (true) return new MethodDecl(t,new Identifier(methodID.toString()),fl,vl,sl,e);}
    throw new Error("Missing return statement in function");
  }

  final public FormalList FormalList() throws ParseException {
  Type t;
  Token formalListId;
  Formal formal1;
  FormalList fl = new FormalList();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BOOLEAN:
    case INTEGER:
    case ID:
      t = Type();
      formalListId = jj_consume_token(ID);
    formal1 = new Formal(t,new Identifier(formalListId.image)); fl.addElement(formal1);
      label_8:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[7] = jj_gen;
          break label_8;
        }
        FormalRest(fl);
      }
                                                                                                              {if (true) return fl;}
      break;
    default:
      jj_la1[8] = jj_gen;
    {if (true) return fl;}
    }
    throw new Error("Missing return statement in function");
  }

  final public void FormalRest(FormalList fl) throws ParseException {
  Type t;
  Token id;
    jj_consume_token(COMMA);
    t = Type();
    id = jj_consume_token(ID);
    fl.addElement(new Formal(t,new Identifier(id.image)));
  }

  final public Type Type() throws ParseException {
        Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
      jj_consume_token(INTEGER);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LSQPAREN:
        jj_consume_token(LSQPAREN);
        jj_consume_token(RSQPAREN);
                                         {if (true) return new IntArrayType();}
        break;
      default:
        jj_la1[9] = jj_gen;
                                                                          {if (true) return new IntegerType();}
      }
      break;
    case BOOLEAN:
      jj_consume_token(BOOLEAN);
    {if (true) return new BooleanType();}
      break;
    case ID:
      t = jj_consume_token(ID);
    {if (true) return new IdentifierType(t.image);}
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Statement Statement() throws ParseException {
  Token t;
  Statement stm1,stm2;
  StatementList sl = new StatementList();
  Exp e1,e2;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACE:
      jj_consume_token(LBRACE);
      label_9:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LBRACE:
        case IF:
        case WHILE:
        case PRINT:
        case ID:
          ;
          break;
        default:
          jj_la1[11] = jj_gen;
          break label_9;
        }
        stm1 = Statement();
                                 sl.addElement(stm1);
      }
      jj_consume_token(RBRACE);
   {if (true) return new Block(sl);}
      break;
    case IF:
      jj_consume_token(IF);
      jj_consume_token(LPAREN);
      e1 = Exp();
      jj_consume_token(RPAREN);
      stm1 = Statement();
      jj_consume_token(ELSE);
      stm2 = Statement();
    {if (true) return new If(e1,stm1,stm2);}
      break;
    case WHILE:
      jj_consume_token(WHILE);
      jj_consume_token(LPAREN);
      e1 = Exp();
      jj_consume_token(RPAREN);
      stm1 = Statement();
    {if (true) return new While(e1,stm1);}
      break;
    case PRINT:
      jj_consume_token(PRINT);
      jj_consume_token(LPAREN);
      e1 = Exp();
      jj_consume_token(RPAREN);
      jj_consume_token(SEMICOLON);
    {if (true) return new Print(e1);}
      break;
    case ID:
      t = jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASSIGN:
        jj_consume_token(ASSIGN);
        e1 = Exp();
        jj_consume_token(SEMICOLON);
      {if (true) return new Assign(new Identifier(t.image),e1);}
        break;
      case LSQPAREN:
        jj_consume_token(LSQPAREN);
        e1 = Exp();
        jj_consume_token(RSQPAREN);
        jj_consume_token(ASSIGN);
        e2 = Exp();
        jj_consume_token(SEMICOLON);
    {if (true) return new ArrayAssign(new Identifier(t.image),e1,e2);}
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Exp Exp() throws ParseException {
  Exp exp1;
  Token id1;
  Exp exp2;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUM:
      id1 = jj_consume_token(NUM);
                    exp1 = new IntegerLiteral(Integer.parseInt(id1.toString())); {if (true) return ExpLinha(exp1);}
      break;
    case TRUE:
      jj_consume_token(TRUE);
              exp1 = new True(); {if (true) return ExpLinha(exp1);}
      break;
    case FALSE:
      jj_consume_token(FALSE);
               exp1 = new False(); {if (true) return ExpLinha(exp1);}
      break;
    case ID:
      id1 = jj_consume_token(ID);
                   exp1 = new IdentifierExp(id1.toString()); {if (true) return ExpLinha(exp1);}
      break;
    case NEW:
      jj_consume_token(NEW);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER:
        jj_consume_token(INTEGER);
        jj_consume_token(LSQPAREN);
        exp2 = Exp();
        jj_consume_token(RSQPAREN);
                                                               exp1 = new NewArray(exp2); {if (true) return ExpLinha(exp1);}
        break;
      case ID:
        id1 = jj_consume_token(ID);
        jj_consume_token(LPAREN);
        jj_consume_token(RPAREN);
                                      exp1 = new NewObject(new Identifier(id1.toString())); {if (true) return ExpLinha(exp1);}
        break;
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case THIS:
      jj_consume_token(THIS);
              exp1 = new This(); {if (true) return ExpLinha(exp1);}
      break;
    case NOT:
      jj_consume_token(NOT);
      exp2 = Exp();
                         exp1 = new Not(exp2); {if (true) return ExpLinha(exp1);}
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      exp1 = Exp();
      jj_consume_token(RPAREN);
                                     {if (true) return ExpLinha(exp1);}
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Exp ExpLinha(Exp exp1) throws ParseException {
  Exp exp2;
  Token ope;
  ExpList expList;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OP:
      ope = jj_consume_token(OP);
      exp2 = Exp();
                             if(ope.toString().equals("&&")) {if (true) return new And(exp1,exp2);}
                                                        if(ope.toString().equals("+")) {if (true) return new Plus(exp1,exp2);}
                                                        if(ope.toString().equals("-")){if (true) return new Minus(exp1,exp2);}
                                                        if(ope.toString().equals("*")){if (true) return new Times(exp1,exp2);}
                                                        if(ope.toString().equals("<")){if (true) return new LessThan(exp1,exp2);}
      break;
    case LSQPAREN:
      jj_consume_token(LSQPAREN);
      exp2 = Exp();
      jj_consume_token(RSQPAREN);
                                          {if (true) return new ArrayLookup(exp1,exp2);}
      break;
    case DOT:
      jj_consume_token(DOT);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LENGTH:
        jj_consume_token(LENGTH);
                          {if (true) return new ArrayLength(exp1);}
        break;
      case ID:
        ope = jj_consume_token(ID);
        jj_consume_token(LPAREN);
        expList = ExpList();
        jj_consume_token(RPAREN);
                                                         {if (true) return new Call(exp1,new Identifier(ope.toString()),expList);}
        break;
      default:
        jj_la1[16] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[17] = jj_gen;
 {if (true) return exp1;}
    }
    throw new Error("Missing return statement in function");
  }

  final public ExpList ExpList() throws ParseException {
  ExpList expList = new ExpList();
  Exp exp1;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LPAREN:
    case NOT:
    case FALSE:
    case NEW:
    case THIS:
    case TRUE:
    case NUM:
    case ID:
      exp1 = Exp();
                  expList.addElement(exp1);
      label_10:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[18] = jj_gen;
          break label_10;
        }
        ExpRest(expList);
      }
                                                                   {if (true) return expList;}
      break;
    default:
      jj_la1[19] = jj_gen;
 {if (true) return expList;}
    }
    throw new Error("Missing return statement in function");
  }

  final public void ExpRest(ExpList expList) throws ParseException {
 Exp exp1;
    jj_consume_token(COMMA);
    exp1 = Exp();
                          expList.addElement(exp1);
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3R_16() {
    if (jj_scan_token(LSQPAREN)) return true;
    return false;
  }

  private boolean jj_3R_14() {
    if (jj_scan_token(BOOLEAN)) return true;
    return false;
  }

  private boolean jj_3R_11() {
    if (jj_3R_12()) return true;
    if (jj_scan_token(ID)) return true;
    return false;
  }

  private boolean jj_3R_13() {
    if (jj_scan_token(INTEGER)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_16()) {
    jj_scanpos = xsp;
    if (jj_3R_17()) return true;
    }
    return false;
  }

  private boolean jj_3R_12() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_13()) {
    jj_scanpos = xsp;
    if (jj_3R_14()) {
    jj_scanpos = xsp;
    if (jj_3R_15()) return true;
    }
    }
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_11()) return true;
    return false;
  }

  private boolean jj_3R_17() {
    return false;
  }

  private boolean jj_3R_15() {
    if (jj_scan_token(ID)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public eg1TokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[20];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x100000,0x2080000,0x20000000,0x2080000,0x20000000,0x800,0x1800800,0x8000,0x2080000,0x200,0x2080000,0x1800800,0x10200,0x1800800,0x2000000,0x10440080,0x4000000,0x24200,0x8000,0x10440080,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x200,0x0,0x200,0x0,0x20,0x208,0x0,0x200,0x0,0x200,0x208,0x0,0x208,0x200,0x306,0x200,0x0,0x0,0x306,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public eg1(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public eg1(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new eg1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public eg1(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new eg1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public eg1(eg1TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(eg1TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[43];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 20; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 43; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
