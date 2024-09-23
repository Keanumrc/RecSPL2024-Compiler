public class Main{

    public static void main(String[] args){

        //----------------------NUMBER CLASS STATES----------------------//

        State num1 = new State("num1", true, "N");
        State num2 = new State("num2", false, "");
        State num3 = new State("num3", false, "");
        State num4 = new State("num4", true, "N");
        State num5 = new State("num5", false, "");
        State num6 = new State("num6", true, "N");

        //--------------------NUMBER CLASS TRANSITIONS-------------------//

        num1.addTransition('.', num5);

        num2.addTransition('0', num3);
        num2.addTransitions("123456789", num4);

        num3.addTransition('.', num5);

        num4.addTransitions("0123456789", num4);
        num4.addTransition('.', num5);

        num5.addTransition('0', num5);
        num5.addTransitions("123456789", num6);
        
        num6.addTransitions("123456789", num6);
        num6.addTransition('0', num5);

        //-----------------------TEXT CLASS STATES-----------------------//

        State text1 = new State("text1", false, "");
        State text2 = new State("text2", false, "");
        State text3 = new State("text3", false, "");
        State text4 = new State("text4", false, "");
        State text5 = new State("text5", false, "");
        State text6 = new State("text6", false, "");
        State text7 = new State("text7", false, "");
        State text8 = new State("text8", false, "");
        State text9 = new State("text9", false, "");
        State text10 = new State("text10", true, "T");

        //--------------------TEXT CLASS TRANSITIONS---------------------//

        text1.addTransitions("ABCDEFGHIJKLMNOPQRSTUVWXYZ", text2);

        text2.addTransitions("abcdefghijklmnopqrstuvwxyz", text3);
        text2.addTransition('"', text10);

        text3.addTransitions("abcdefghijklmnopqrstuvwxyz", text4);
        text3.addTransition('"', text10);

        text4.addTransitions("abcdefghijklmnopqrstuvwxyz", text5);
        text4.addTransition('"', text10);

        text5.addTransitions("abcdefghijklmnopqrstuvwxyz", text6);
        text5.addTransition('"', text10);

        text6.addTransitions("abcdefghijklmnopqrstuvwxyz", text7);
        text6.addTransition('"', text10);

        text7.addTransitions("abcdefghijklmnopqrstuvwxyz", text8);
        text7.addTransition('"', text10);

        text8.addTransitions("abcdefghijklmnopqrstuvwxyz", text9);
        text8.addTransition('"', text10);

        text9.addTransition('"', text10);

        //---------------------FUNCTION CLASS STATES---------------------//

        State function1 = new State("function1", false, "");
        State function2 = new State("function2", false, "");
        State function3 = new State("function3", true, "F");
        State function4 = new State("function4", true, "F");

        //-------------------FUNCTION CLASS TRANSITIONS------------------//

        function1.addTransition('_', function2);
        function2.addTransitions("abcdefghijklmnopqrstuvwxyz", function3);
        function3.addTransitions("abcdefghijklmnopqrstuvwxyz0123456789", function4);
        function4.addTransitions("abcdefghijklmnopqrstuvwxyz0123456789", function4);

        //---------------------VARIABLE CLASS STATES---------------------//

        State variable1 = new State("variable1", false, "");
        State variable2 = new State("variable2", false, "");
        State variable3 = new State("variable3", true, "V");
        State variable4 = new State("variable4", true, "V");

        //-------------------VARIABLE CLASS TRANSITIONS------------------//

        variable1.addTransition('_', variable2);
        variable2.addTransitions("abcdefghijklmnopqrstuvwxyz", variable3);
        variable3.addTransitions("abcdefghijklmnopqrstuvwxyz0123456789", variable4);
        variable4.addTransitions("abcdefghijklmnopqrstuvwxyz0123456789", variable4);

        //-----------------------A KEYWORDS STATES-----------------------//

        State a1 = new State("a1", false, "");
        State a2 = new State("a2", false, "");
        State a3 = new State("a3", true, "ADD");
        State a4 = new State("a4", false, "");
        State a5 = new State("a5", true, "AND");

        //---------------------A KEYWORDS TRANSITIONS--------------------//

        a1.addTransition('d', a2);
        a1.addTransition('n', a4);

        a2.addTransition('d', a3);

        a4.addTransition('d', a5);

        //-----------------------B KEYWORDS STATES-----------------------//

        State b1 = new State("b1", false, "");
        State b2 = new State("b2", false, "");
        State b3 = new State("b3", false, "");
        State b4 = new State("b4", false, "");
        State b5 = new State("b5", true, "BEGIN");

        //---------------------B KEYWORDS TRANSITIONS--------------------//

        b1.addTransition('e', b2);

        b2.addTransition('g', b3);

        b3.addTransition('i', b4);

        b4.addTransition('n', b5);

        //-----------------------D KEYWORDS STATES-----------------------//

        State d1 = new State("d1", false, "");
        State d2 = new State("d2", false, "");
        State d3 = new State("d3", true, "DIV");

        //---------------------D KEYWORDS TRANSITIONS--------------------//

        d1.addTransition('i', d2);

        d2.addTransition('v', d3);

        //-----------------------E KEYWORDS STATES-----------------------//

        State e1 = new State("e1", false, "");
        State e2 = new State("e2", false, "");
        State e3 = new State("e3", false, "");
        State e4 = new State("e4", true, "ELSE");
        State e5 = new State("e5", false, "");
        State e6 = new State("e6", true, "END");
        State e7 = new State("e7", true, "EQ");

        //---------------------E KEYWORDS TRANSITIONS--------------------//

        e1.addTransition('l', e2);
        e1.addTransition('n', e5);
        e1.addTransition('q', e7);

        e2.addTransition('s', e3);

        e3.addTransition('e', e4);

        e5.addTransition('d', e6);

        //-----------------------G KEYWORDS STATES-----------------------//

        State g1 = new State("g1", false, "");
        State g2 = new State("g2", false, "");
        State g3 = new State("g3", true, "GRT");

        //---------------------G KEYWORDS TRANSITIONS--------------------//

        g1.addTransition('r', g2);

        g2.addTransition('t', g3);

        //-----------------------H KEYWORDS STATES-----------------------//

        State h1 = new State("h1", false, "");
        State h2 = new State("h2", false, "");
        State h3 = new State("h3", false, "");
        State h4 = new State("h4", true, "HALT");

        //---------------------H KEYWORDS TRANSITIONS--------------------//

        h1.addTransition('a', h2);

        h2.addTransition('l', h3);

        h3.addTransition('t', h4);

        //-----------------------I KEYWORDS STATES-----------------------//

        State i1 = new State("i1", false, "");
        State i2 = new State("i2", true, "IF");
        State i3 = new State("i3", false, "");
        State i4 = new State("i4", false, "");
        State i5 = new State("i5", false, "");
        State i6 = new State("i6", true, "INPUT");

        //---------------------I KEYWORDS TRANSITIONS--------------------//

        i1.addTransition('f', i2);
        i1.addTransition('n', i3);

        i3.addTransition('p', i4);

        i4.addTransition('u', i5);

        i5.addTransition('t', i6);

        //-----------------------M KEYWORDS STATES-----------------------//

        //old way

        State m1 = new State("m1", false, "");
        State m2 = new State("m2", false, "");
        State m3 = new State("m3", false, "");
        State m4 = new State("m4", true, "MUL");
        State m5 = new State("m5", false, "");
        State m6 = new State("m6", true, "MAIN");

        //---------------------M KEYWORDS TRANSITIONS--------------------//

        m1.addTransition('u', m2);
        m1.addTransition('a', m3);

        m2.addTransition('l', m4);

        m3.addTransition('i', m5);

        m5.addTransition('n', m6);

        //-----------------------N KEYWORDS STATES-----------------------//

        //old way

        State n1 = new State("n1", false, "");
        State n2 = new State("n2", false, "");
        State n3 = new State("n3", false, "");
        State n4 = new State("n4", true, "NUM");
        State n5 = new State("n5", true, "NOT");

        //---------------------N KEYWORDS TRANSITIONS--------------------//

        n1.addTransition('u', n2);
        n1.addTransition('o', n3);

        n2.addTransition('m', n4);

        n3.addTransition('t', n5);

        //-----------------------O KEYWORDS STATES-----------------------//

        State o1 = new State("o1", false, "");
        State o2 = new State("o2", true, "OR");

        //---------------------O KEYWORDS TRANSITIONS--------------------//

        o1.addTransition('r', o2);

        //-----------------------P KEYWORDS STATES-----------------------//

        State p1 = new State("p1", false, "");
        State p2 = new State("p2", false, "");
        State p3 = new State("p3", false, "");
        State p4 = new State("p4", false, "");
        State p5 = new State("p5", true, "PRINT");

        //---------------------P KEYWORDS TRANSITIONS--------------------//

        p1.addTransition('r', p2);

        p2.addTransition('i', p3);

        p3.addTransition('n', p4);

        p4.addTransition('t', p5);

        //-----------------------R KEYWORDS STATES-----------------------//

        State r1 = new State("r1", false, "");
        State r2 = new State("r2", false, "");
        State r3 = new State("r3", false, "");
        State r4 = new State("r4", false, "");
        State r5 = new State("r5", false, "");
        State r6 = new State("r6", true, "RETURN");

        //---------------------R KEYWORDS TRANSITIONS--------------------//

        r1.addTransition('e', r2);

        r2.addTransition('t', r3);

        r3.addTransition('u', r4);

        r4.addTransition('r', r5);

        r5.addTransition('n', r6);

        //-----------------------S KEYWORDS STATES-----------------------//

        State s1 = new State("s1", false, "");
        State s2 = new State("s2", false, "");
        State s3 = new State("s3", false, "");
        State s4 = new State("s4", true, "SKIP");
        State s5 = new State("s5", false, "");
        State s6 = new State("s6", false, "");
        State s7 = new State("s7", true, "SQRT");
        State s8 = new State("s8", false, "");
        State s9 = new State("s9", true, "SUB");

        //---------------------S KEYWORDS TRANSITIONS--------------------//

        s1.addTransition('k', s2);
        s1.addTransition('q', s5);
        s1.addTransition('u', s8);

        s2.addTransition('i', s3);

        s3.addTransition('p', s4);

        s5.addTransition('r', s6);

        s6.addTransition('t', s7);

        s8.addTransition('b', s9);

        //-----------------------T KEYWORDS STATES-----------------------//

        State t1 = new State("t1", false, "");
        State t2 = new State("t2", false, "");
        State t3 = new State("t3", false, "");
        State t4 = new State("t4", true, "TEXT");
        State t5 = new State("t5", false, "");
        State t6 = new State("t6", false, "");
        State t7 = new State("t7", true, "THEN");

        //---------------------T KEYWORDS TRANSITIONS--------------------//

        t1.addTransition('e', t2);
        t1.addTransition('h', t5);

        t2.addTransition('x', t3);

        t3.addTransition('t', t4);

        t5.addTransition('e', t6);

        t6.addTransition('n', t7);

        //-----------------------V KEYWORDS STATES-----------------------//

        State v1 = new State("v1", false, "");
        State v2 = new State("v2", false, "");
        State v3 = new State("v3", false, "");
        State v4 = new State("v4", true, "VOID");

        //---------------------V KEYWORDS TRANSITIONS--------------------//

        v1.addTransition('o', v2);

        v2.addTransition('i', v3);

        v3.addTransition('d', v4);

        //--------------------------OTHER STATES-------------------------//

        State comma = new State("comma", true, "COMMA");
        State semicolon = new State("semicolon", true, "SEMICOLON");
        State stream = new State("stream", true, "STREAM");
        State assign = new State("assign", true, "ASSIGN");
        State leftParenthesis = new State("leftParenthesis", true, "LEFT_PARENTHESIS");
        State rightParenthesis = new State("rightParenthesis", true, "RIGHT_PARENTHESIS");
        State leftBrace = new State("leftBrace", true, "LEFT_BRACE");
        State rightBrace = new State("rightBrace", true, "RIGHT_BRACE");

        //--------------------------START STATE--------------------------//

        State start = new State("start", false, "");

        //---------------------START STATE TRANSITIONS-------------------//

        start.addTransition('0', num1);
        start.addTransition('-', num2);
        start.addTransitions("123456789", num4);
        start.addTransition('"', text1);
        start.addTransition('F', function1);
        start.addTransition('V', variable1);
        start.addTransition('m', m1);
        start.addTransition('n', n1);
        start.addTransition('t', t1);
        start.addTransition('e', e1);
        start.addTransition('s', s1);
        start.addTransition('i', i1);
        start.addTransition('a', a1);
        start.addTransition('b', b1);
        start.addTransition('h', h1);
        start.addTransition('p', p1);
        start.addTransition('o', o1);
        start.addTransition('d', d1);
        start.addTransition('r', r1);
        start.addTransition('g', g1);
        start.addTransition('v', v1);
        start.addTransition(',', comma);
        start.addTransition(';', semicolon);
        start.addTransition('<', stream);
        start.addTransition('=', assign);
        start.addTransition('(', leftParenthesis);
        start.addTransition(')', rightParenthesis);
        start.addTransition('{', leftBrace);
        start.addTransition('}', rightBrace);

        Lexer l = new Lexer(new DFA(start));
        long begin = System.currentTimeMillis();
        String lexResult = l.lex("0.0009000V_abc");
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println(lexResult);
        System.out.println("TIME: " + time + "ms");

    }

}