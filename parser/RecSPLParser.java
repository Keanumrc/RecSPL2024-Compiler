public class RecSPLParser {

    public static void parse(String[] tokens) {

        // ----------------------ALL STATES----------------------//

        State s0 = new State(0);
        State s1 = new State(1);
        State s2 = new State(2);
        State s3 = new State(3);
        State s4 = new State(4);
        State s5 = new State(5);
        State s6 = new State(6);
        State s7 = new State(7);
        State s8 = new State(8);
        State s9 = new State(9);
        State s10 = new State(10);
        State s11 = new State(11);
        State s12 = new State(12);
        State s13 = new State(13);
        State s14 = new State(14);
        State s15 = new State(15);
        State s16 = new State(16);
        State s17 = new State(17);
        State s18 = new State(18);
        State s19 = new State(19);
        State s20 = new State(20);
        State s21 = new State(21);
        State s22 = new State(22);
        State s23 = new State(23);
        State s24 = new State(24);
        State s25 = new State(25);
        State s26 = new State(26);
        State s27 = new State(27);
        State s28 = new State(28);
        State s29 = new State(29);
        State s30 = new State(30);
        State s31 = new State(31);
        State s32 = new State(32);
        State s33 = new State(33);
        State s34 = new State(34);
        State s35 = new State(35);
        State s36 = new State(36);
        State s37 = new State(37);
        State s38 = new State(38);
        State s39 = new State(39);
        State s40 = new State(40);
        State s41 = new State(41);
        State s42 = new State(42);
        State s43 = new State(43);
        State s44 = new State(44);
        State s45 = new State(45);
        State s46 = new State(46);
        State s47 = new State(47);
        State s48 = new State(48);
        State s49 = new State(49);
        State s50 = new State(50);
        State s51 = new State(51);
        State s52 = new State(52);
        State s53 = new State(53);
        State s54 = new State(54);
        State s55 = new State(55);
        State s56 = new State(56);
        State s57 = new State(57);
        State s58 = new State(58);
        State s59 = new State(59);
        State s60 = new State(60);
        State s61 = new State(61);
        State s62 = new State(62);
        State s63 = new State(63);
        State s64 = new State(64);
        State s65 = new State(65);
        State s66 = new State(66);
        State s67 = new State(67);
        State s68 = new State(68);
        State s69 = new State(69);
        State s70 = new State(70);
        State s71 = new State(71);
        State s72 = new State(72);
        State s73 = new State(73);
        State s74 = new State(74);
        State s75 = new State(75);
        State s76 = new State(76);
        State s77 = new State(77);
        State s78 = new State(78);
        State s79 = new State(79);
        State s80 = new State(80);
        State s81 = new State(81);
        State s82 = new State(82);
        State s83 = new State(83);
        State s84 = new State(84);
        State s85 = new State(85);
        State s86 = new State(86);
        State s87 = new State(87);
        State s88 = new State(88);
        State s89 = new State(89);
        State s90 = new State(90);
        State s91 = new State(91);
        State s92 = new State(92);
        State s93 = new State(93);
        State s94 = new State(94);
        State s95 = new State(95);
        State s96 = new State(96);
        State s97 = new State(97);
        State s98 = new State(98);
        State s99 = new State(99);
        State s100 = new State(100);
        State s101 = new State(101);
        State s102 = new State(102);
        State s103 = new State(103);
        State s104 = new State(104);
        State s105 = new State(105);
        State s106 = new State(106);
        State s107 = new State(107);
        State s108 = new State(108);
        State s109 = new State(109);
        State s110 = new State(110);
        State s111 = new State(111);
        State s112 = new State(112);
        State s113 = new State(113);
        State s114 = new State(114);
        State s115 = new State(115);
        State s116 = new State(116);
        State s117 = new State(117);
        State s118 = new State(118);
        State s119 = new State(119);
        State s120 = new State(120);
        State s121 = new State(121);
        State s122 = new State(122);
        State s123 = new State(123);
        State s124 = new State(124);
        State s125 = new State(125);
        State s126 = new State(126);
        State s127 = new State(127);

        // ----------------------ALL PRODUCTIONS----------------------//

        Production p0 = new Production("PROG' -> PROG");
        Production p1 = new Production("PROG -> main GLOBVARS ALGO FUNCTIONS");
        Production p2 = new Production("GLOBVARS -> ");
        Production p3 = new Production("GLOBVARS -> VTYP VNAME , GLOBVARS");
        Production p4 = new Production("VTYP -> num");
        Production p5 = new Production("VTYP -> text");
        Production p6 = new Production("VNAME -> V");
        Production p7 = new Production("ALGO -> begin INSTRUC end");
        Production p8 = new Production("INSTRUC -> ");
        Production p9 = new Production("INSTRUC -> COMMAND ; INSTRUC");
        Production p10 = new Production("COMMAND -> skip");
        Production p11 = new Production("COMMAND -> halt");
        Production p12 = new Production("COMMAND -> print ATOMIC");
        Production p13 = new Production("COMMAND -> ASSIGN");
        Production p14 = new Production("COMMAND -> CALL");
        Production p15 = new Production("COMMAND -> BRANCH");
        Production p16 = new Production("COMMAND -> return ATOMIC");
        Production p17 = new Production("ATOMIC -> VNAME");
        Production p18 = new Production("ATOMIC -> CONST");
        Production p19 = new Production("CONST -> N");
        Production p20 = new Production("CONST -> T");
        Production p21 = new Production("ASSIGN -> VNAME < input");
        Production p22 = new Production("ASSIGN -> VNAME = TERM");
        Production p23 = new Production("CALL -> FNAME ( ATOMIC , ATOMIC , ATOMIC )");
        Production p24 = new Production("BRANCH -> if COND then ALGO else ALGO");
        Production p25 = new Production("TERM -> ATOMIC");
        Production p26 = new Production("TERM -> CALL");
        Production p27 = new Production("TERM -> OP");
        Production p28 = new Production("OP -> UNOP ( ARG )");
        Production p29 = new Production("OP -> BINOP ( ARG , ARG )");
        Production p30 = new Production("ARG -> ATOMIC");
        Production p31 = new Production("ARG -> OP");
        Production p32 = new Production("COND -> SIMPLE");
        Production p33 = new Production("COND -> COMPOSIT");
        Production p34 = new Production("SIMPLE -> BINOP ( ATOMIC , ATOMIC )");
        Production p35 = new Production("COMPOSIT -> BINOP ( SIMPLE , SIMPLE )");
        Production p36 = new Production("COMPOSIT -> UNOP ( SIMPLE )");
        Production p37 = new Production("UNOP -> not");
        Production p38 = new Production("UNOP -> sqrt");
        Production p39 = new Production("BINOP -> or");
        Production p40 = new Production("BINOP -> and");
        Production p41 = new Production("BINOP -> eq");
        Production p42 = new Production("BINOP -> grt");
        Production p43 = new Production("BINOP -> add");
        Production p44 = new Production("BINOP -> sub");
        Production p45 = new Production("BINOP -> mul");
        Production p46 = new Production("BINOP -> div");
        Production p47 = new Production("FNAME -> F");
        Production p48 = new Production("FUNCTIONS -> ");
        Production p49 = new Production("FUNCTIONS -> DECL FUNCTIONS");
        Production p50 = new Production("DECL -> HEADER BODY");
        Production p51 = new Production("HEADER -> FTYP FNAME ( VNAME , VNAME , VNAME )");
        Production p52 = new Production("FTYP -> num");
        Production p53 = new Production("FTYP -> void");
        Production p54 = new Production("BODY -> PROLOG LOCVARS ALGO EPILOG SUBFUNCS end");
        Production p55 = new Production("PROLOG -> {");
        Production p56 = new Production("EPILOG -> }");
        Production p57 = new Production("LOCVARS -> VTYP VNAME , VTYP VNAME , VTYP VNAME ,");
        Production p58 = new Production("SUBFUNCS -> FUNCTIONS");

        // ----------------------LINK STATES----------------------//

        s0.addTransition("MAIN", new ShiftAction(s2));
        s0.addTransition("PROG", new GotoAction(s1));
        s1.addTransition("$", new AcceptAction());
        s2.addTransition("NUM", new ShiftAction(s5));
        s2.addTransition("TEXT", new ShiftAction(s6));
        s2.addTransition("BEGIN", new ReduceAction(p2));
        s2.addTransition("GLOBVARS", new GotoAction(s3));
        s2.addTransition("VTYP", new GotoAction(s4));
        s3.addTransition("BEGIN", new ShiftAction(s8));
        s3.addTransition("ALGO", new GotoAction(s7));
        s4.addTransition("V", new ShiftAction(s10));
        s4.addTransition("VNAME", new GotoAction(s9));
        s5.addTransition("V", new ReduceAction(p4));
        s6.addTransition("V", new ReduceAction(p5));
        s7.addTransition("NUM", new ShiftAction(s15));
        s7.addTransition("END", new ReduceAction(p48));
        s7.addTransition("VOID", new ShiftAction(s16));
        s7.addTransition("$", new ReduceAction(p48));
        s7.addTransition("FUNCTIONS", new GotoAction(s11));
        s7.addTransition("DECL", new GotoAction(s12));
        s7.addTransition("HEADER", new GotoAction(s13));
        s7.addTransition("FTYP", new GotoAction(s14));
        s8.addTransition("V", new ShiftAction(s10));
        s8.addTransition("END", new ReduceAction(p8));
        s8.addTransition("SKIP", new ShiftAction(s19));
        s8.addTransition("HALT", new ShiftAction(s20));
        s8.addTransition("PRINT", new ShiftAction(s21));
        s8.addTransition("RETURN", new ShiftAction(s25));
        s8.addTransition("IF", new ShiftAction(s28));
        s8.addTransition("F", new ShiftAction(s29));
        s8.addTransition("VNAME", new GotoAction(s26));
        s8.addTransition("INSTRUC", new GotoAction(s17));
        s8.addTransition("COMMAND", new GotoAction(s18));
        s8.addTransition("ASSIGN", new GotoAction(s22));
        s8.addTransition("CALL", new GotoAction(s23));
        s8.addTransition("BRANCH", new GotoAction(s24));
        s8.addTransition("FNAME", new GotoAction(s27));
        s9.addTransition(",", new ShiftAction(s30));
        s10.addTransition(",", new ReduceAction(p6));
        s10.addTransition(";", new ReduceAction(p6));
        s10.addTransition("<", new ReduceAction(p6));
        s10.addTransition("=", new ReduceAction(p6));
        s10.addTransition(")", new ReduceAction(p6));
        s11.addTransition("$", new ReduceAction(p1));
        s12.addTransition("NUM", new ShiftAction(s15));
        s12.addTransition("END", new ReduceAction(p48));
        s12.addTransition("VOID", new ShiftAction(s16));
        s12.addTransition("$", new ReduceAction(p48));
        s12.addTransition("FUNCTIONS", new GotoAction(s31));
        s12.addTransition("DECL", new GotoAction(s12));
        s12.addTransition("HEADER", new GotoAction(s13));
        s12.addTransition("FTYP", new GotoAction(s14));
        s13.addTransition("{", new ShiftAction(s34));
        s13.addTransition("BODY", new GotoAction(s32));
        s13.addTransition("PROLOG", new GotoAction(s33));
        s14.addTransition("F", new ShiftAction(s29));
        s14.addTransition("FNAME", new GotoAction(s35));
        s15.addTransition("F", new ReduceAction(p52));
        s16.addTransition("F", new ReduceAction(p53));
        s17.addTransition("END", new ShiftAction(s36));
        s18.addTransition(";", new ShiftAction(s37));
        s19.addTransition(";", new ReduceAction(p10));
        s20.addTransition(";", new ReduceAction(p11));
        s21.addTransition("V", new ShiftAction(s10));
        s21.addTransition("N", new ShiftAction(s41));
        s21.addTransition("T", new ShiftAction(s42));
        s21.addTransition("VNAME", new GotoAction(s39));
        s21.addTransition("ATOMIC", new GotoAction(s38));
        s21.addTransition("CONST", new GotoAction(s40));
        s22.addTransition(";", new ReduceAction(p13));
        s23.addTransition(";", new ReduceAction(p14));
        s24.addTransition(";", new ReduceAction(p15));
        s25.addTransition("V", new ShiftAction(s10));
        s25.addTransition("N", new ShiftAction(s41));
        s25.addTransition("T", new ShiftAction(s42));
        s25.addTransition("VNAME", new GotoAction(s39));
        s25.addTransition("ATOMIC", new GotoAction(s43));
        s25.addTransition("CONST", new GotoAction(s40));
        s26.addTransition("<", new ShiftAction(s44));
        s26.addTransition("=", new ShiftAction(s45));
        s27.addTransition("(", new ShiftAction(s46));
        s28.addTransition("NOT", new ShiftAction(s60));
        s28.addTransition("SQRT", new ShiftAction(s61));
        s28.addTransition("OR", new ShiftAction(s52));
        s28.addTransition("AND", new ShiftAction(s53));
        s28.addTransition("EQ", new ShiftAction(s54));
        s28.addTransition("GRT", new ShiftAction(s55));
        s28.addTransition("ADD", new ShiftAction(s56));
        s28.addTransition("SUB", new ShiftAction(s57));
        s28.addTransition("MUL", new ShiftAction(s58));
        s28.addTransition("DIV", new ShiftAction(s59));
        s28.addTransition("COND", new GotoAction(s47));
        s28.addTransition("SIMPLE", new GotoAction(s48));
        s28.addTransition("COMPOSIT", new GotoAction(s49));
        s28.addTransition("UNOP", new GotoAction(s51));
        s28.addTransition("BINOP", new GotoAction(s50));
        s29.addTransition("(", new ReduceAction(p47));
        s30.addTransition("NUM", new ShiftAction(s5));
        s30.addTransition("TEXT", new ShiftAction(s6));
        s30.addTransition("BEGIN", new ReduceAction(p2));
        s30.addTransition("GLOBVARS", new GotoAction(s62));
        s30.addTransition("VTYP", new GotoAction(s4));
        s31.addTransition("END", new ReduceAction(p49));
        s31.addTransition("$", new ReduceAction(p49));
        s32.addTransition("NUM", new ReduceAction(p50));
        s32.addTransition("END", new ReduceAction(p50));
        s32.addTransition("VOID", new ReduceAction(p50));
        s32.addTransition("$", new ReduceAction(p50));
        s33.addTransition("NUM", new ShiftAction(s5));
        s33.addTransition("TEXT", new ShiftAction(s6));
        s33.addTransition("VTYP", new GotoAction(s64));
        s33.addTransition("LOCVARS", new GotoAction(s63));
        s34.addTransition("NUM", new ReduceAction(p55));
        s34.addTransition("TEXT", new ReduceAction(p55));
        s35.addTransition("(", new ShiftAction(s65));
        s36.addTransition("NUM", new ReduceAction(p7));
        s36.addTransition(";", new ReduceAction(p7));
        s36.addTransition("ELSE", new ReduceAction(p7));
        s36.addTransition("VOID", new ReduceAction(p7));
        s36.addTransition("}", new ReduceAction(p7));
        s36.addTransition("$", new ReduceAction(p7));
        s37.addTransition("V", new ShiftAction(s10));
        s37.addTransition("END", new ReduceAction(p8));
        s37.addTransition("SKIP", new ShiftAction(s19));
        s37.addTransition("HALT", new ShiftAction(s20));
        s37.addTransition("PRINT", new ShiftAction(s21));
        s37.addTransition("RETURN", new ShiftAction(s25));
        s37.addTransition("IF", new ShiftAction(s28));
        s37.addTransition("F", new ShiftAction(s29));
        s37.addTransition("VNAME", new GotoAction(s26));
        s37.addTransition("INSTRUC", new GotoAction(s66));
        s37.addTransition("COMMAND", new GotoAction(s18));
        s37.addTransition("ASSIGN", new GotoAction(s22));
        s37.addTransition("CALL", new GotoAction(s23));
        s37.addTransition("BRANCH", new GotoAction(s24));
        s37.addTransition("FNAME", new GotoAction(s27));
        s38.addTransition(";", new ReduceAction(p12));
        s39.addTransition(",", new ReduceAction(p17));
        s39.addTransition(";", new ReduceAction(p17));
        s39.addTransition(")", new ReduceAction(p17));
        s40.addTransition(",", new ReduceAction(p18));
        s40.addTransition(";", new ReduceAction(p18));
        s40.addTransition(")", new ReduceAction(p18));
        s41.addTransition(",", new ReduceAction(p19));
        s41.addTransition(";", new ReduceAction(p19));
        s41.addTransition(")", new ReduceAction(p19));
        s42.addTransition(",", new ReduceAction(p20));
        s42.addTransition(";", new ReduceAction(p20));
        s42.addTransition(")", new ReduceAction(p20));
        s43.addTransition(";", new ReduceAction(p16));
        s44.addTransition("INPUT", new ShiftAction(s67));
        s45.addTransition("V", new ShiftAction(s10));
        s45.addTransition("N", new ShiftAction(s41));
        s45.addTransition("T", new ShiftAction(s42));
        s45.addTransition("NOT", new ShiftAction(s60));
        s45.addTransition("SQRT", new ShiftAction(s61));
        s45.addTransition("OR", new ShiftAction(s52));
        s45.addTransition("AND", new ShiftAction(s53));
        s45.addTransition("EQ", new ShiftAction(s54));
        s45.addTransition("GRT", new ShiftAction(s55));
        s45.addTransition("ADD", new ShiftAction(s56));
        s45.addTransition("SUB", new ShiftAction(s57));
        s45.addTransition("MUL", new ShiftAction(s58));
        s45.addTransition("DIV", new ShiftAction(s59));
        s45.addTransition("F", new ShiftAction(s29));
        s45.addTransition("VNAME", new GotoAction(s39));
        s45.addTransition("ATOMIC", new GotoAction(s69));
        s45.addTransition("CONST", new GotoAction(s40));
        s45.addTransition("CALL", new GotoAction(s70));
        s45.addTransition("TERM", new GotoAction(s68));
        s45.addTransition("OP", new GotoAction(s71));
        s45.addTransition("UNOP", new GotoAction(s72));
        s45.addTransition("BINOP", new GotoAction(s73));
        s45.addTransition("FNAME", new GotoAction(s27));
        s46.addTransition("V", new ShiftAction(s10));
        s46.addTransition("N", new ShiftAction(s41));
        s46.addTransition("T", new ShiftAction(s42));
        s46.addTransition("VNAME", new GotoAction(s39));
        s46.addTransition("ATOMIC", new GotoAction(s74));
        s46.addTransition("CONST", new GotoAction(s40));
        s47.addTransition("THEN", new ShiftAction(s75));
        s48.addTransition("THEN", new ReduceAction(p32));
        s49.addTransition("THEN", new ReduceAction(p33));
        s50.addTransition("(", new ShiftAction(s76));
        s51.addTransition("(", new ShiftAction(s77));
        s52.addTransition("(", new ReduceAction(p39));
        s53.addTransition("(", new ReduceAction(p40));
        s54.addTransition("(", new ReduceAction(p41));
        s55.addTransition("(", new ReduceAction(p42));
        s56.addTransition("(", new ReduceAction(p43));
        s57.addTransition("(", new ReduceAction(p44));
        s58.addTransition("(", new ReduceAction(p45));
        s59.addTransition("(", new ReduceAction(p46));
        s60.addTransition("(", new ReduceAction(p37));
        s61.addTransition("(", new ReduceAction(p38));
        s62.addTransition("BEGIN", new ReduceAction(p3));
        s63.addTransition("BEGIN", new ShiftAction(s8));
        s63.addTransition("ALGO", new GotoAction(s78));
        s64.addTransition("V", new ShiftAction(s10));
        s64.addTransition("VNAME", new GotoAction(s79));
        s65.addTransition("V", new ShiftAction(s10));
        s65.addTransition("VNAME", new GotoAction(s80));
        s66.addTransition("END", new ReduceAction(p9));
        s67.addTransition(";", new ReduceAction(p21));
        s68.addTransition(";", new ReduceAction(p22));
        s69.addTransition(";", new ReduceAction(p25));
        s70.addTransition(";", new ReduceAction(p26));
        s71.addTransition(";", new ReduceAction(p27));
        s72.addTransition("(", new ShiftAction(s81));
        s73.addTransition("(", new ShiftAction(s82));
        s74.addTransition(",", new ShiftAction(s83));
        s75.addTransition("BEGIN", new ShiftAction(s8));
        s75.addTransition("ALGO", new GotoAction(s84));
        s76.addTransition("V", new ShiftAction(s10));
        s76.addTransition("N", new ShiftAction(s41));
        s76.addTransition("T", new ShiftAction(s42));
        s76.addTransition("OR", new ShiftAction(s52));
        s76.addTransition("AND", new ShiftAction(s53));
        s76.addTransition("EQ", new ShiftAction(s54));
        s76.addTransition("GRT", new ShiftAction(s55));
        s76.addTransition("ADD", new ShiftAction(s56));
        s76.addTransition("SUB", new ShiftAction(s57));
        s76.addTransition("MUL", new ShiftAction(s58));
        s76.addTransition("DIV", new ShiftAction(s59));
        s76.addTransition("VNAME", new GotoAction(s39));
        s76.addTransition("ATOMIC", new GotoAction(s85));
        s76.addTransition("CONST", new GotoAction(s40));
        s76.addTransition("SIMPLE", new GotoAction(s86));
        s76.addTransition("BINOP", new GotoAction(s87));
        s77.addTransition("OR", new ShiftAction(s52));
        s77.addTransition("AND", new ShiftAction(s53));
        s77.addTransition("EQ", new ShiftAction(s54));
        s77.addTransition("GRT", new ShiftAction(s55));
        s77.addTransition("ADD", new ShiftAction(s56));
        s77.addTransition("SUB", new ShiftAction(s57));
        s77.addTransition("MUL", new ShiftAction(s58));
        s77.addTransition("DIV", new ShiftAction(s59));
        s77.addTransition("SIMPLE", new GotoAction(s88));
        s77.addTransition("BINOP", new GotoAction(s87));
        s78.addTransition("}", new ShiftAction(s90));
        s78.addTransition("EPILOG", new GotoAction(s89));
        s79.addTransition(",", new ShiftAction(s91));
        s80.addTransition(",", new ShiftAction(s92));
        s81.addTransition("V", new ShiftAction(s10));
        s81.addTransition("N", new ShiftAction(s41));
        s81.addTransition("T", new ShiftAction(s42));
        s81.addTransition("NOT", new ShiftAction(s60));
        s81.addTransition("SQRT", new ShiftAction(s61));
        s81.addTransition("OR", new ShiftAction(s52));
        s81.addTransition("AND", new ShiftAction(s53));
        s81.addTransition("EQ", new ShiftAction(s54));
        s81.addTransition("GRT", new ShiftAction(s55));
        s81.addTransition("ADD", new ShiftAction(s56));
        s81.addTransition("SUB", new ShiftAction(s57));
        s81.addTransition("MUL", new ShiftAction(s58));
        s81.addTransition("DIV", new ShiftAction(s59));
        s81.addTransition("VNAME", new GotoAction(s39));
        s81.addTransition("ATOMIC", new GotoAction(s94));
        s81.addTransition("CONST", new GotoAction(s40));
        s81.addTransition("OP", new GotoAction(s95));
        s81.addTransition("ARG", new GotoAction(s93));
        s81.addTransition("UNOP", new GotoAction(s72));
        s81.addTransition("BINOP", new GotoAction(s73));
        s82.addTransition("V", new ShiftAction(s10));
        s82.addTransition("N", new ShiftAction(s41));
        s82.addTransition("T", new ShiftAction(s42));
        s82.addTransition("NOT", new ShiftAction(s60));
        s82.addTransition("SQRT", new ShiftAction(s61));
        s82.addTransition("OR", new ShiftAction(s52));
        s82.addTransition("AND", new ShiftAction(s53));
        s82.addTransition("EQ", new ShiftAction(s54));
        s82.addTransition("GRT", new ShiftAction(s55));
        s82.addTransition("ADD", new ShiftAction(s56));
        s82.addTransition("SUB", new ShiftAction(s57));
        s82.addTransition("MUL", new ShiftAction(s58));
        s82.addTransition("DIV", new ShiftAction(s59));
        s82.addTransition("VNAME", new GotoAction(s39));
        s82.addTransition("ATOMIC", new GotoAction(s94));
        s82.addTransition("CONST", new GotoAction(s40));
        s82.addTransition("OP", new GotoAction(s95));
        s82.addTransition("ARG", new GotoAction(s96));
        s82.addTransition("UNOP", new GotoAction(s72));
        s82.addTransition("BINOP", new GotoAction(s73));
        s83.addTransition("V", new ShiftAction(s10));
        s83.addTransition("N", new ShiftAction(s41));
        s83.addTransition("T", new ShiftAction(s42));
        s83.addTransition("VNAME", new GotoAction(s39));
        s83.addTransition("ATOMIC", new GotoAction(s97));
        s83.addTransition("CONST", new GotoAction(s40));
        s84.addTransition("ELSE", new ShiftAction(s98));
        s85.addTransition(",", new ShiftAction(s99));
        s86.addTransition(",", new ShiftAction(s100));
        s87.addTransition("(", new ShiftAction(s101));
        s88.addTransition(")", new ShiftAction(s102));
        s89.addTransition("NUM", new ShiftAction(s15));
        s89.addTransition("END", new ReduceAction(p48));
        s89.addTransition("VOID", new ShiftAction(s16));
        s89.addTransition("$", new ReduceAction(p48));
        s89.addTransition("FUNCTIONS", new GotoAction(s104));
        s89.addTransition("DECL", new GotoAction(s12));
        s89.addTransition("HEADER", new GotoAction(s13));
        s89.addTransition("FTYP", new GotoAction(s14));
        s89.addTransition("SUBFUNCS", new GotoAction(s103));
        s90.addTransition("NUM", new ReduceAction(p56));
        s90.addTransition("END", new ReduceAction(p56));
        s90.addTransition("VOID", new ReduceAction(p56));
        s90.addTransition("$", new ReduceAction(p56));
        s91.addTransition("NUM", new ShiftAction(s5));
        s91.addTransition("TEXT", new ShiftAction(s6));
        s91.addTransition("VTYP", new GotoAction(s105));
        s92.addTransition("V", new ShiftAction(s10));
        s92.addTransition("VNAME", new GotoAction(s106));
        s93.addTransition(")", new ShiftAction(s107));
        s94.addTransition(",", new ReduceAction(p30));
        s94.addTransition(")", new ReduceAction(p30));
        s95.addTransition(",", new ReduceAction(p31));
        s95.addTransition(")", new ReduceAction(p31));
        s96.addTransition(",", new ShiftAction(s108));
        s97.addTransition(",", new ShiftAction(s109));
        s98.addTransition("BEGIN", new ShiftAction(s8));
        s98.addTransition("ALGO", new GotoAction(s110));
        s99.addTransition("V", new ShiftAction(s10));
        s99.addTransition("N", new ShiftAction(s41));
        s99.addTransition("T", new ShiftAction(s42));
        s99.addTransition("VNAME", new GotoAction(s39));
        s99.addTransition("ATOMIC", new GotoAction(s111));
        s99.addTransition("CONST", new GotoAction(s40));
        s100.addTransition("OR", new ShiftAction(s52));
        s100.addTransition("AND", new ShiftAction(s53));
        s100.addTransition("EQ", new ShiftAction(s54));
        s100.addTransition("GRT", new ShiftAction(s55));
        s100.addTransition("ADD", new ShiftAction(s56));
        s100.addTransition("SUB", new ShiftAction(s57));
        s100.addTransition("MUL", new ShiftAction(s58));
        s100.addTransition("DIV", new ShiftAction(s59));
        s100.addTransition("SIMPLE", new GotoAction(s112));
        s100.addTransition("BINOP", new GotoAction(s87));
        s101.addTransition("V", new ShiftAction(s10));
        s101.addTransition("N", new ShiftAction(s41));
        s101.addTransition("T", new ShiftAction(s42));
        s101.addTransition("VNAME", new GotoAction(s39));
        s101.addTransition("ATOMIC", new GotoAction(s85));
        s101.addTransition("CONST", new GotoAction(s40));
        s102.addTransition("THEN", new ReduceAction(p36));
        s103.addTransition("END", new ShiftAction(s113));
        s104.addTransition("END", new ReduceAction(p58));
        s105.addTransition("V", new ShiftAction(s10));
        s105.addTransition("VNAME", new GotoAction(s114));
        s106.addTransition(",", new ShiftAction(s115));
        s107.addTransition(",", new ReduceAction(p28));
        s107.addTransition(";", new ReduceAction(p28));
        s107.addTransition(")", new ReduceAction(p28));
        s108.addTransition("V", new ShiftAction(s10));
        s108.addTransition("N", new ShiftAction(s41));
        s108.addTransition("T", new ShiftAction(s42));
        s108.addTransition("NOT", new ShiftAction(s60));
        s108.addTransition("SQRT", new ShiftAction(s61));
        s108.addTransition("OR", new ShiftAction(s52));
        s108.addTransition("AND", new ShiftAction(s53));
        s108.addTransition("EQ", new ShiftAction(s54));
        s108.addTransition("GRT", new ShiftAction(s55));
        s108.addTransition("ADD", new ShiftAction(s56));
        s108.addTransition("SUB", new ShiftAction(s57));
        s108.addTransition("MUL", new ShiftAction(s58));
        s108.addTransition("DIV", new ShiftAction(s59));
        s108.addTransition("VNAME", new GotoAction(s39));
        s108.addTransition("ATOMIC", new GotoAction(s94));
        s108.addTransition("CONST", new GotoAction(s40));
        s108.addTransition("OP", new GotoAction(s95));
        s108.addTransition("ARG", new GotoAction(s116));
        s108.addTransition("UNOP", new GotoAction(s72));
        s108.addTransition("BINOP", new GotoAction(s73));
        s109.addTransition("V", new ShiftAction(s10));
        s109.addTransition("N", new ShiftAction(s41));
        s109.addTransition("T", new ShiftAction(s42));
        s109.addTransition("VNAME", new GotoAction(s39));
        s109.addTransition("ATOMIC", new GotoAction(s117));
        s109.addTransition("CONST", new GotoAction(s40));
        s110.addTransition(";", new ReduceAction(p24));
        s111.addTransition(")", new ShiftAction(s118));
        s112.addTransition(")", new ShiftAction(s119));
        s113.addTransition("NUM", new ReduceAction(p54));
        s113.addTransition("END", new ReduceAction(p54));
        s113.addTransition("VOID", new ReduceAction(p54));
        s113.addTransition("$", new ReduceAction(p54));
        s114.addTransition(",", new ShiftAction(s120));
        s115.addTransition("V", new ShiftAction(s10));
        s115.addTransition("VNAME", new GotoAction(s121));
        s116.addTransition(")", new ShiftAction(s122));
        s117.addTransition(")", new ShiftAction(s123));
        s118.addTransition(",", new ReduceAction(p34));
        s118.addTransition(")", new ReduceAction(p34));
        s118.addTransition("THEN", new ReduceAction(p34));
        s119.addTransition("THEN", new ReduceAction(p35));
        s120.addTransition("NUM", new ShiftAction(s5));
        s120.addTransition("TEXT", new ShiftAction(s6));
        s120.addTransition("VTYP", new GotoAction(s124));
        s121.addTransition(")", new ShiftAction(s125));
        s122.addTransition(",", new ReduceAction(p29));
        s122.addTransition(";", new ReduceAction(p29));
        s122.addTransition(")", new ReduceAction(p29));
        s123.addTransition(";", new ReduceAction(p23));
        s124.addTransition("V", new ShiftAction(s10));
        s124.addTransition("VNAME", new GotoAction(s126));
        s125.addTransition("{", new ReduceAction(p51));
        s126.addTransition(",", new ShiftAction(s127));
        s127.addTransition("BEGIN", new ReduceAction(p57));

        Parser parser = new Parser(s0);

        parser.parse(tokens);

    }

}