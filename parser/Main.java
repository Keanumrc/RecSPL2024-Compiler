class Main {

    public static void main(String[] args) {

        SLRParseTableReader.readTable("parser/SLRParseTable.html");

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

        // ----------------------LINK STATES----------------------//

        s0.addTransition("MAIN", Action.ActionType.SHIFT, s1);
        s1.addTransition("NUM", Action.ActionType.SHIFT, s4);
        s1.addTransition("TEXT", Action.ActionType.SHIFT, s5);
        s1.addTransition("BEGIN", Action.ActionType.REDUCE, s1);
        s1.addTransition("GLOBVARS", Action.ActionType.GOTO, s2);
        s1.addTransition("VTYP", Action.ActionType.GOTO, s3);
        s2.addTransition("BEGIN", Action.ActionType.SHIFT, s7);
        s2.addTransition("ALGO", Action.ActionType.GOTO, s6);
        s3.addTransition("V", Action.ActionType.SHIFT, s9);
        s3.addTransition("VNAME", Action.ActionType.GOTO, s8);
        s4.addTransition("V", Action.ActionType.REDUCE, s3);
        s5.addTransition("V", Action.ActionType.REDUCE, s4);
        s6.addTransition("NUM", Action.ActionType.SHIFT, s14);
        s6.addTransition("END", Action.ActionType.REDUCE, s47);
        s6.addTransition("VOID", Action.ActionType.SHIFT, s15);
        s6.addTransition("$", Action.ActionType.REDUCE, s47);
        s6.addTransition("FUNCTIONS", Action.ActionType.GOTO, s10);
        s6.addTransition("DECL", Action.ActionType.GOTO, s11);
        s6.addTransition("HEADER", Action.ActionType.GOTO, s12);
        s6.addTransition("FTYP", Action.ActionType.GOTO, s13);
        s7.addTransition("V", Action.ActionType.SHIFT, s9);
        s7.addTransition("END", Action.ActionType.REDUCE, s7);
        s7.addTransition("SKIP", Action.ActionType.SHIFT, s18);
        s7.addTransition("HALT", Action.ActionType.SHIFT, s19);
        s7.addTransition("PRINT", Action.ActionType.SHIFT, s20);
        s7.addTransition("RETURN", Action.ActionType.SHIFT, s24);
        s7.addTransition("IF", Action.ActionType.SHIFT, s27);
        s7.addTransition("F", Action.ActionType.SHIFT, s28);
        s7.addTransition("VNAME", Action.ActionType.GOTO, s25);
        s7.addTransition("INSTRUC", Action.ActionType.GOTO, s16);
        s7.addTransition("COMMAND", Action.ActionType.GOTO, s17);
        s7.addTransition("ASSIGN", Action.ActionType.GOTO, s21);
        s7.addTransition("CALL", Action.ActionType.GOTO, s22);
        s7.addTransition("BRANCH", Action.ActionType.GOTO, s23);
        s7.addTransition("FNAME", Action.ActionType.GOTO, s26);
        s8.addTransition(",", Action.ActionType.SHIFT, s29);
        s9.addTransition(",", Action.ActionType.REDUCE, s5);
        s9.addTransition(";", Action.ActionType.REDUCE, s5);
        s9.addTransition("&LT;", Action.ActionType.REDUCE, s5);
        s9.addTransition("=", Action.ActionType.REDUCE, s5);
        s9.addTransition(")", Action.ActionType.REDUCE, s5);
        s10.addTransition("$", Action.ActionType.SHIFT, sacc);
        s11.addTransition("NUM", Action.ActionType.SHIFT, s14);
        s11.addTransition("END", Action.ActionType.REDUCE, s47);
        s11.addTransition("VOID", Action.ActionType.SHIFT, s15);
        s11.addTransition("$", Action.ActionType.REDUCE, s47);
        s11.addTransition("FUNCTIONS", Action.ActionType.GOTO, s30);
        s11.addTransition("DECL", Action.ActionType.GOTO, s11);
        s11.addTransition("HEADER", Action.ActionType.GOTO, s12);
        s11.addTransition("FTYP", Action.ActionType.GOTO, s13);
        s12.addTransition("{", Action.ActionType.SHIFT, s33);
        s12.addTransition("BODY", Action.ActionType.GOTO, s31);
        s12.addTransition("PROLOG", Action.ActionType.GOTO, s32);
        s13.addTransition("F", Action.ActionType.SHIFT, s28);
        s13.addTransition("FNAME", Action.ActionType.GOTO, s34);
        s14.addTransition("F", Action.ActionType.REDUCE, s51);
        s15.addTransition("F", Action.ActionType.REDUCE, s52);
        s16.addTransition("END", Action.ActionType.SHIFT, s35);
        s17.addTransition(";", Action.ActionType.SHIFT, s36);
        s18.addTransition(";", Action.ActionType.REDUCE, s9);
        s19.addTransition(";", Action.ActionType.REDUCE, s10);
        s20.addTransition("V", Action.ActionType.SHIFT, s9);
        s20.addTransition("N", Action.ActionType.SHIFT, s40);
        s20.addTransition("T", Action.ActionType.SHIFT, s41);
        s20.addTransition("VNAME", Action.ActionType.GOTO, s38);
        s20.addTransition("ATOMIC", Action.ActionType.GOTO, s37);
        s20.addTransition("CONST", Action.ActionType.GOTO, s39);
        s21.addTransition(";", Action.ActionType.REDUCE, s12);
        s22.addTransition(";", Action.ActionType.REDUCE, s13);
        s23.addTransition(";", Action.ActionType.REDUCE, s14);
        s24.addTransition("V", Action.ActionType.SHIFT, s9);
        s24.addTransition("N", Action.ActionType.SHIFT, s40);
        s24.addTransition("T", Action.ActionType.SHIFT, s41);
        s24.addTransition("VNAME", Action.ActionType.GOTO, s38);
        s24.addTransition("ATOMIC", Action.ActionType.GOTO, s42);
        s24.addTransition("CONST", Action.ActionType.GOTO, s39);
        s25.addTransition("&LT;", Action.ActionType.SHIFT, s43);
        s25.addTransition("=", Action.ActionType.SHIFT, s44);
        s26.addTransition("(", Action.ActionType.SHIFT, s45);
        s27.addTransition("NOT", Action.ActionType.SHIFT, s59);
        s27.addTransition("SQRT", Action.ActionType.SHIFT, s60);
        s27.addTransition("OR", Action.ActionType.SHIFT, s51);
        s27.addTransition("AND", Action.ActionType.SHIFT, s52);
        s27.addTransition("EQ", Action.ActionType.SHIFT, s53);
        s27.addTransition("GRT", Action.ActionType.SHIFT, s54);
        s27.addTransition("ADD", Action.ActionType.SHIFT, s55);
        s27.addTransition("SUB", Action.ActionType.SHIFT, s56);
        s27.addTransition("MUL", Action.ActionType.SHIFT, s57);
        s27.addTransition("DIV", Action.ActionType.SHIFT, s58);
        s27.addTransition("COND", Action.ActionType.GOTO, s46);
        s27.addTransition("SIMPLE", Action.ActionType.GOTO, s47);
        s27.addTransition("COMPOSIT", Action.ActionType.GOTO, s48);
        s27.addTransition("UNOP", Action.ActionType.GOTO, s50);
        s27.addTransition("BINOP", Action.ActionType.GOTO, s49);
        s28.addTransition("(", Action.ActionType.REDUCE, s46);
        s29.addTransition("NUM", Action.ActionType.SHIFT, s4);
        s29.addTransition("TEXT", Action.ActionType.SHIFT, s5);
        s29.addTransition("BEGIN", Action.ActionType.REDUCE, s1);
        s29.addTransition("GLOBVARS", Action.ActionType.GOTO, s61);
        s29.addTransition("VTYP", Action.ActionType.GOTO, s3);
        s30.addTransition("END", Action.ActionType.REDUCE, s48);
        s30.addTransition("$", Action.ActionType.REDUCE, s48);
        s31.addTransition("NUM", Action.ActionType.REDUCE, s49);
        s31.addTransition("END", Action.ActionType.REDUCE, s49);
        s31.addTransition("VOID", Action.ActionType.REDUCE, s49);
        s31.addTransition("$", Action.ActionType.REDUCE, s49);
        s32.addTransition("NUM", Action.ActionType.SHIFT, s4);
        s32.addTransition("TEXT", Action.ActionType.SHIFT, s5);
        s32.addTransition("VTYP", Action.ActionType.GOTO, s63);
        s32.addTransition("LOCVARS", Action.ActionType.GOTO, s62);
        s33.addTransition("NUM", Action.ActionType.REDUCE, s54);
        s33.addTransition("TEXT", Action.ActionType.REDUCE, s54);
        s34.addTransition("(", Action.ActionType.SHIFT, s64);
        s35.addTransition("NUM", Action.ActionType.REDUCE, s6);
        s35.addTransition(";", Action.ActionType.REDUCE, s6);
        s35.addTransition("ELSE", Action.ActionType.REDUCE, s6);
        s35.addTransition("VOID", Action.ActionType.REDUCE, s6);
        s35.addTransition("}", Action.ActionType.REDUCE, s6);
        s35.addTransition("$", Action.ActionType.REDUCE, s6);
        s36.addTransition("V", Action.ActionType.SHIFT, s9);
        s36.addTransition("END", Action.ActionType.REDUCE, s7);
        s36.addTransition("SKIP", Action.ActionType.SHIFT, s18);
        s36.addTransition("HALT", Action.ActionType.SHIFT, s19);
        s36.addTransition("PRINT", Action.ActionType.SHIFT, s20);
        s36.addTransition("RETURN", Action.ActionType.SHIFT, s24);
        s36.addTransition("IF", Action.ActionType.SHIFT, s27);
        s36.addTransition("F", Action.ActionType.SHIFT, s28);
        s36.addTransition("VNAME", Action.ActionType.GOTO, s25);
        s36.addTransition("INSTRUC", Action.ActionType.GOTO, s65);
        s36.addTransition("COMMAND", Action.ActionType.GOTO, s17);
        s36.addTransition("ASSIGN", Action.ActionType.GOTO, s21);
        s36.addTransition("CALL", Action.ActionType.GOTO, s22);
        s36.addTransition("BRANCH", Action.ActionType.GOTO, s23);
        s36.addTransition("FNAME", Action.ActionType.GOTO, s26);
        s37.addTransition(";", Action.ActionType.REDUCE, s11);
        s38.addTransition(",", Action.ActionType.REDUCE, s16);
        s38.addTransition(";", Action.ActionType.REDUCE, s16);
        s38.addTransition(")", Action.ActionType.REDUCE, s16);
        s39.addTransition(",", Action.ActionType.REDUCE, s17);
        s39.addTransition(";", Action.ActionType.REDUCE, s17);
        s39.addTransition(")", Action.ActionType.REDUCE, s17);
        s40.addTransition(",", Action.ActionType.REDUCE, s18);
        s40.addTransition(";", Action.ActionType.REDUCE, s18);
        s40.addTransition(")", Action.ActionType.REDUCE, s18);
        s41.addTransition(",", Action.ActionType.REDUCE, s19);
        s41.addTransition(";", Action.ActionType.REDUCE, s19);
        s41.addTransition(")", Action.ActionType.REDUCE, s19);
        s42.addTransition(";", Action.ActionType.REDUCE, s15);
        s43.addTransition("INPUT", Action.ActionType.SHIFT, s66);
        s44.addTransition("V", Action.ActionType.SHIFT, s9);
        s44.addTransition("N", Action.ActionType.SHIFT, s40);
        s44.addTransition("T", Action.ActionType.SHIFT, s41);
        s44.addTransition("NOT", Action.ActionType.SHIFT, s59);
        s44.addTransition("SQRT", Action.ActionType.SHIFT, s60);
        s44.addTransition("OR", Action.ActionType.SHIFT, s51);
        s44.addTransition("AND", Action.ActionType.SHIFT, s52);
        s44.addTransition("EQ", Action.ActionType.SHIFT, s53);
        s44.addTransition("GRT", Action.ActionType.SHIFT, s54);
        s44.addTransition("ADD", Action.ActionType.SHIFT, s55);
        s44.addTransition("SUB", Action.ActionType.SHIFT, s56);
        s44.addTransition("MUL", Action.ActionType.SHIFT, s57);
        s44.addTransition("DIV", Action.ActionType.SHIFT, s58);
        s44.addTransition("F", Action.ActionType.SHIFT, s28);
        s44.addTransition("VNAME", Action.ActionType.GOTO, s38);
        s44.addTransition("ATOMIC", Action.ActionType.GOTO, s68);
        s44.addTransition("CONST", Action.ActionType.GOTO, s39);
        s44.addTransition("CALL", Action.ActionType.GOTO, s69);
        s44.addTransition("TERM", Action.ActionType.GOTO, s67);
        s44.addTransition("OP", Action.ActionType.GOTO, s70);
        s44.addTransition("UNOP", Action.ActionType.GOTO, s71);
        s44.addTransition("BINOP", Action.ActionType.GOTO, s72);
        s44.addTransition("FNAME", Action.ActionType.GOTO, s26);
        s45.addTransition("V", Action.ActionType.SHIFT, s9);
        s45.addTransition("N", Action.ActionType.SHIFT, s40);
        s45.addTransition("T", Action.ActionType.SHIFT, s41);
        s45.addTransition("VNAME", Action.ActionType.GOTO, s38);
        s45.addTransition("ATOMIC", Action.ActionType.GOTO, s73);
        s45.addTransition("CONST", Action.ActionType.GOTO, s39);
        s46.addTransition("THEN", Action.ActionType.SHIFT, s74);
        s47.addTransition("THEN", Action.ActionType.REDUCE, s31);
        s48.addTransition("THEN", Action.ActionType.REDUCE, s32);
        s49.addTransition("(", Action.ActionType.SHIFT, s75);
        s50.addTransition("(", Action.ActionType.SHIFT, s76);
        s51.addTransition("(", Action.ActionType.REDUCE, s38);
        s52.addTransition("(", Action.ActionType.REDUCE, s39);
        s53.addTransition("(", Action.ActionType.REDUCE, s40);
        s54.addTransition("(", Action.ActionType.REDUCE, s41);
        s55.addTransition("(", Action.ActionType.REDUCE, s42);
        s56.addTransition("(", Action.ActionType.REDUCE, s43);
        s57.addTransition("(", Action.ActionType.REDUCE, s44);
        s58.addTransition("(", Action.ActionType.REDUCE, s45);
        s59.addTransition("(", Action.ActionType.REDUCE, s36);
        s60.addTransition("(", Action.ActionType.REDUCE, s37);
        s61.addTransition("BEGIN", Action.ActionType.REDUCE, s2);
        s62.addTransition("BEGIN", Action.ActionType.SHIFT, s7);
        s62.addTransition("ALGO", Action.ActionType.GOTO, s77);
        s63.addTransition("V", Action.ActionType.SHIFT, s9);
        s63.addTransition("VNAME", Action.ActionType.GOTO, s78);
        s64.addTransition("V", Action.ActionType.SHIFT, s9);
        s64.addTransition("VNAME", Action.ActionType.GOTO, s79);
        s65.addTransition("END", Action.ActionType.REDUCE, s8);
        s66.addTransition(";", Action.ActionType.REDUCE, s20);
        s67.addTransition(";", Action.ActionType.REDUCE, s21);
        s68.addTransition(";", Action.ActionType.REDUCE, s24);
        s69.addTransition(";", Action.ActionType.REDUCE, s25);
        s70.addTransition(";", Action.ActionType.REDUCE, s26);
        s71.addTransition("(", Action.ActionType.SHIFT, s80);
        s72.addTransition("(", Action.ActionType.SHIFT, s81);
        s73.addTransition(",", Action.ActionType.SHIFT, s82);
        s74.addTransition("BEGIN", Action.ActionType.SHIFT, s7);
        s74.addTransition("ALGO", Action.ActionType.GOTO, s83);
        s75.addTransition("V", Action.ActionType.SHIFT, s9);
        s75.addTransition("N", Action.ActionType.SHIFT, s40);
        s75.addTransition("T", Action.ActionType.SHIFT, s41);
        s75.addTransition("OR", Action.ActionType.SHIFT, s51);
        s75.addTransition("AND", Action.ActionType.SHIFT, s52);
        s75.addTransition("EQ", Action.ActionType.SHIFT, s53);
        s75.addTransition("GRT", Action.ActionType.SHIFT, s54);
        s75.addTransition("ADD", Action.ActionType.SHIFT, s55);
        s75.addTransition("SUB", Action.ActionType.SHIFT, s56);
        s75.addTransition("MUL", Action.ActionType.SHIFT, s57);
        s75.addTransition("DIV", Action.ActionType.SHIFT, s58);
        s75.addTransition("VNAME", Action.ActionType.GOTO, s38);
        s75.addTransition("ATOMIC", Action.ActionType.GOTO, s84);
        s75.addTransition("CONST", Action.ActionType.GOTO, s39);
        s75.addTransition("SIMPLE", Action.ActionType.GOTO, s85);
        s75.addTransition("BINOP", Action.ActionType.GOTO, s86);
        s76.addTransition("OR", Action.ActionType.SHIFT, s51);
        s76.addTransition("AND", Action.ActionType.SHIFT, s52);
        s76.addTransition("EQ", Action.ActionType.SHIFT, s53);
        s76.addTransition("GRT", Action.ActionType.SHIFT, s54);
        s76.addTransition("ADD", Action.ActionType.SHIFT, s55);
        s76.addTransition("SUB", Action.ActionType.SHIFT, s56);
        s76.addTransition("MUL", Action.ActionType.SHIFT, s57);
        s76.addTransition("DIV", Action.ActionType.SHIFT, s58);
        s76.addTransition("SIMPLE", Action.ActionType.GOTO, s87);
        s76.addTransition("BINOP", Action.ActionType.GOTO, s86);
        s77.addTransition("}", Action.ActionType.SHIFT, s89);
        s77.addTransition("EPILOG", Action.ActionType.GOTO, s88);
        s78.addTransition(",", Action.ActionType.SHIFT, s90);
        s79.addTransition(",", Action.ActionType.SHIFT, s91);
        s80.addTransition("V", Action.ActionType.SHIFT, s9);
        s80.addTransition("N", Action.ActionType.SHIFT, s40);
        s80.addTransition("T", Action.ActionType.SHIFT, s41);
        s80.addTransition("NOT", Action.ActionType.SHIFT, s59);
        s80.addTransition("SQRT", Action.ActionType.SHIFT, s60);
        s80.addTransition("OR", Action.ActionType.SHIFT, s51);
        s80.addTransition("AND", Action.ActionType.SHIFT, s52);
        s80.addTransition("EQ", Action.ActionType.SHIFT, s53);
        s80.addTransition("GRT", Action.ActionType.SHIFT, s54);
        s80.addTransition("ADD", Action.ActionType.SHIFT, s55);
        s80.addTransition("SUB", Action.ActionType.SHIFT, s56);
        s80.addTransition("MUL", Action.ActionType.SHIFT, s57);
        s80.addTransition("DIV", Action.ActionType.SHIFT, s58);
        s80.addTransition("VNAME", Action.ActionType.GOTO, s38);
        s80.addTransition("ATOMIC", Action.ActionType.GOTO, s93);
        s80.addTransition("CONST", Action.ActionType.GOTO, s39);
        s80.addTransition("OP", Action.ActionType.GOTO, s94);
        s80.addTransition("ARG", Action.ActionType.GOTO, s92);
        s80.addTransition("UNOP", Action.ActionType.GOTO, s71);
        s80.addTransition("BINOP", Action.ActionType.GOTO, s72);
        s81.addTransition("V", Action.ActionType.SHIFT, s9);
        s81.addTransition("N", Action.ActionType.SHIFT, s40);
        s81.addTransition("T", Action.ActionType.SHIFT, s41);
        s81.addTransition("NOT", Action.ActionType.SHIFT, s59);
        s81.addTransition("SQRT", Action.ActionType.SHIFT, s60);
        s81.addTransition("OR", Action.ActionType.SHIFT, s51);
        s81.addTransition("AND", Action.ActionType.SHIFT, s52);
        s81.addTransition("EQ", Action.ActionType.SHIFT, s53);
        s81.addTransition("GRT", Action.ActionType.SHIFT, s54);
        s81.addTransition("ADD", Action.ActionType.SHIFT, s55);
        s81.addTransition("SUB", Action.ActionType.SHIFT, s56);
        s81.addTransition("MUL", Action.ActionType.SHIFT, s57);
        s81.addTransition("DIV", Action.ActionType.SHIFT, s58);
        s81.addTransition("VNAME", Action.ActionType.GOTO, s38);
        s81.addTransition("ATOMIC", Action.ActionType.GOTO, s93);
        s81.addTransition("CONST", Action.ActionType.GOTO, s39);
        s81.addTransition("OP", Action.ActionType.GOTO, s94);
        s81.addTransition("ARG", Action.ActionType.GOTO, s95);
        s81.addTransition("UNOP", Action.ActionType.GOTO, s71);
        s81.addTransition("BINOP", Action.ActionType.GOTO, s72);
        s82.addTransition("V", Action.ActionType.SHIFT, s9);
        s82.addTransition("N", Action.ActionType.SHIFT, s40);
        s82.addTransition("T", Action.ActionType.SHIFT, s41);
        s82.addTransition("VNAME", Action.ActionType.GOTO, s38);
        s82.addTransition("ATOMIC", Action.ActionType.GOTO, s96);
        s82.addTransition("CONST", Action.ActionType.GOTO, s39);
        s83.addTransition("ELSE", Action.ActionType.SHIFT, s97);
        s84.addTransition(",", Action.ActionType.SHIFT, s98);
        s85.addTransition(",", Action.ActionType.SHIFT, s99);
        s86.addTransition("(", Action.ActionType.SHIFT, s100);
        s87.addTransition(")", Action.ActionType.SHIFT, s101);
        s88.addTransition("NUM", Action.ActionType.SHIFT, s14);
        s88.addTransition("END", Action.ActionType.REDUCE, s47);
        s88.addTransition("VOID", Action.ActionType.SHIFT, s15);
        s88.addTransition("$", Action.ActionType.REDUCE, s47);
        s88.addTransition("FUNCTIONS", Action.ActionType.GOTO, s103);
        s88.addTransition("DECL", Action.ActionType.GOTO, s11);
        s88.addTransition("HEADER", Action.ActionType.GOTO, s12);
        s88.addTransition("FTYP", Action.ActionType.GOTO, s13);
        s88.addTransition("SUBFUNCS", Action.ActionType.GOTO, s102);
        s89.addTransition("NUM", Action.ActionType.REDUCE, s55);
        s89.addTransition("END", Action.ActionType.REDUCE, s55);
        s89.addTransition("VOID", Action.ActionType.REDUCE, s55);
        s89.addTransition("$", Action.ActionType.REDUCE, s55);
        s90.addTransition("NUM", Action.ActionType.SHIFT, s4);
        s90.addTransition("TEXT", Action.ActionType.SHIFT, s5);
        s90.addTransition("VTYP", Action.ActionType.GOTO, s104);
        s91.addTransition("V", Action.ActionType.SHIFT, s9);
        s91.addTransition("VNAME", Action.ActionType.GOTO, s105);
        s92.addTransition(")", Action.ActionType.SHIFT, s106);
        s93.addTransition(",", Action.ActionType.REDUCE, s29);
        s93.addTransition(")", Action.ActionType.REDUCE, s29);
        s94.addTransition(",", Action.ActionType.REDUCE, s30);
        s94.addTransition(")", Action.ActionType.REDUCE, s30);
        s95.addTransition(",", Action.ActionType.SHIFT, s107);
        s96.addTransition(",", Action.ActionType.SHIFT, s108);
        s97.addTransition("BEGIN", Action.ActionType.SHIFT, s7);
        s97.addTransition("ALGO", Action.ActionType.GOTO, s109);
        s98.addTransition("V", Action.ActionType.SHIFT, s9);
        s98.addTransition("N", Action.ActionType.SHIFT, s40);
        s98.addTransition("T", Action.ActionType.SHIFT, s41);
        s98.addTransition("VNAME", Action.ActionType.GOTO, s38);
        s98.addTransition("ATOMIC", Action.ActionType.GOTO, s110);
        s98.addTransition("CONST", Action.ActionType.GOTO, s39);
        s99.addTransition("OR", Action.ActionType.SHIFT, s51);
        s99.addTransition("AND", Action.ActionType.SHIFT, s52);
        s99.addTransition("EQ", Action.ActionType.SHIFT, s53);
        s99.addTransition("GRT", Action.ActionType.SHIFT, s54);
        s99.addTransition("ADD", Action.ActionType.SHIFT, s55);
        s99.addTransition("SUB", Action.ActionType.SHIFT, s56);
        s99.addTransition("MUL", Action.ActionType.SHIFT, s57);
        s99.addTransition("DIV", Action.ActionType.SHIFT, s58);
        s99.addTransition("SIMPLE", Action.ActionType.GOTO, s111);
        s99.addTransition("BINOP", Action.ActionType.GOTO, s86);
        s100.addTransition("V", Action.ActionType.SHIFT, s9);
        s100.addTransition("N", Action.ActionType.SHIFT, s40);
        s100.addTransition("T", Action.ActionType.SHIFT, s41);
        s100.addTransition("VNAME", Action.ActionType.GOTO, s38);
        s100.addTransition("ATOMIC", Action.ActionType.GOTO, s84);
        s100.addTransition("CONST", Action.ActionType.GOTO, s39);
        s101.addTransition("THEN", Action.ActionType.REDUCE, s35);
        s102.addTransition("END", Action.ActionType.SHIFT, s112);
        s103.addTransition("END", Action.ActionType.REDUCE, s57);
        s104.addTransition("V", Action.ActionType.SHIFT, s9);
        s104.addTransition("VNAME", Action.ActionType.GOTO, s113);
        s105.addTransition(",", Action.ActionType.SHIFT, s114);
        s106.addTransition(",", Action.ActionType.REDUCE, s27);
        s106.addTransition(";", Action.ActionType.REDUCE, s27);
        s106.addTransition(")", Action.ActionType.REDUCE, s27);
        s107.addTransition("V", Action.ActionType.SHIFT, s9);
        s107.addTransition("N", Action.ActionType.SHIFT, s40);
        s107.addTransition("T", Action.ActionType.SHIFT, s41);
        s107.addTransition("NOT", Action.ActionType.SHIFT, s59);
        s107.addTransition("SQRT", Action.ActionType.SHIFT, s60);
        s107.addTransition("OR", Action.ActionType.SHIFT, s51);
        s107.addTransition("AND", Action.ActionType.SHIFT, s52);
        s107.addTransition("EQ", Action.ActionType.SHIFT, s53);
        s107.addTransition("GRT", Action.ActionType.SHIFT, s54);
        s107.addTransition("ADD", Action.ActionType.SHIFT, s55);
        s107.addTransition("SUB", Action.ActionType.SHIFT, s56);
        s107.addTransition("MUL", Action.ActionType.SHIFT, s57);
        s107.addTransition("DIV", Action.ActionType.SHIFT, s58);
        s107.addTransition("VNAME", Action.ActionType.GOTO, s38);
        s107.addTransition("ATOMIC", Action.ActionType.GOTO, s93);
        s107.addTransition("CONST", Action.ActionType.GOTO, s39);
        s107.addTransition("OP", Action.ActionType.GOTO, s94);
        s107.addTransition("ARG", Action.ActionType.GOTO, s115);
        s107.addTransition("UNOP", Action.ActionType.GOTO, s71);
        s107.addTransition("BINOP", Action.ActionType.GOTO, s72);
        s108.addTransition("V", Action.ActionType.SHIFT, s9);
        s108.addTransition("N", Action.ActionType.SHIFT, s40);
        s108.addTransition("T", Action.ActionType.SHIFT, s41);
        s108.addTransition("VNAME", Action.ActionType.GOTO, s38);
        s108.addTransition("ATOMIC", Action.ActionType.GOTO, s116);
        s108.addTransition("CONST", Action.ActionType.GOTO, s39);
        s109.addTransition(";", Action.ActionType.REDUCE, s23);
        s110.addTransition(")", Action.ActionType.SHIFT, s117);
        s111.addTransition(")", Action.ActionType.SHIFT, s118);
        s112.addTransition("NUM", Action.ActionType.REDUCE, s53);
        s112.addTransition("END", Action.ActionType.REDUCE, s53);
        s112.addTransition("VOID", Action.ActionType.REDUCE, s53);
        s112.addTransition("$", Action.ActionType.REDUCE, s53);
        s113.addTransition(",", Action.ActionType.SHIFT, s119);
        s114.addTransition("V", Action.ActionType.SHIFT, s9);
        s114.addTransition("VNAME", Action.ActionType.GOTO, s120);
        s115.addTransition(")", Action.ActionType.SHIFT, s121);
        s116.addTransition(")", Action.ActionType.SHIFT, s122);
        s117.addTransition(",", Action.ActionType.REDUCE, s33);
        s117.addTransition(")", Action.ActionType.REDUCE, s33);
        s117.addTransition("THEN", Action.ActionType.REDUCE, s33);
        s118.addTransition("THEN", Action.ActionType.REDUCE, s34);
        s119.addTransition("NUM", Action.ActionType.SHIFT, s4);
        s119.addTransition("TEXT", Action.ActionType.SHIFT, s5);
        s119.addTransition("VTYP", Action.ActionType.GOTO, s123);
        s120.addTransition(")", Action.ActionType.SHIFT, s124);
        s121.addTransition(",", Action.ActionType.REDUCE, s28);
        s121.addTransition(";", Action.ActionType.REDUCE, s28);
        s121.addTransition(")", Action.ActionType.REDUCE, s28);
        s122.addTransition(";", Action.ActionType.REDUCE, s22);
        s123.addTransition("V", Action.ActionType.SHIFT, s9);
        s123.addTransition("VNAME", Action.ActionType.GOTO, s125);
        s124.addTransition("{", Action.ActionType.REDUCE, s50);
        s125.addTransition(",", Action.ActionType.SHIFT, s126);
        s126.addTransition("BEGIN", Action.ActionType.REDUCE, s56);

    }

}