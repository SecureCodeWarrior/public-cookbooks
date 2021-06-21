package com.example.springexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.util.Scanner;

@SpringBootApplication
public class SpringExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringExamplesApplication.class, args);
    }

    public void SPELRecipe(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        Expression exp = parser.parseExpression(args[1]);
        Scanner sc = new Scanner(System.in);

        String untrusted = sc.nextLine();
        Expression exp1 = parser.parseExpression(untrusted);
    }

    public void dataRecipes() {
        Scanner sc = new Scanner(System.in);
        String untrusted = "'" + sc.nextLine() + "'";

        JdbcTemplate t = new JdbcTemplate();
        //t.queryForObject(untrusted, Object.class);
        String[] params = {"test", "blargh"};
        //t.queryForObject("select * from users where id=" + untrusted, params, Object.class);

        String[] params2 = {untrusted};
        //t.queryForObject("select * from users where id=" + untrusted, params, Object.class);
        t.queryForObject("select * from users where id=?", params, Object.class);
        t.queryForObject("select * from users where id=?", Object.class, untrusted);

        t.queryForList("select * from users where id=" + untrusted);
        t.queryForList("select * from users where id=" + untrusted, params);
        t.queryForList("select * from users where id=?", params, Object.class);
        t.queryForList("select * from users where id=?", Object.class, untrusted);

        t.queryForStream("select * from users where id=" + untrusted, null);
        t.queryForStream("select * from users where id=" + untrusted, (PreparedStatementSetter)null, null);
        t.queryForStream("select * from users where id=" + untrusted, null, null, null);

        t.queryForMap("select * from users where id=" + untrusted);
        t.queryForMap("select * from users where id=" + untrusted, params);
        t.queryForMap("select * from users where id=?", params, Object.class);
        t.queryForMap("select * from users where id=?", Object.class, untrusted);

        t.queryForRowSet("select * from users where id=" + untrusted);
        t.queryForRowSet("select * from users where id=" + untrusted, params);
        t.queryForRowSet("select * from users where id=?", params, Object.class);
        t.queryForRowSet("select * from users where id=?", Object.class, untrusted);

        int[] types = {1,2,3};

        t.update("select * from users where id=" + untrusted);
        t.update("select * from users where id=" + untrusted, params);
        t.update("select * from users where id=" + untrusted, params, types);
        t.update("select * from users where id=?", params, Object.class);
        t.update("select * from users where id=?", Object.class, untrusted);

        t.batchUpdate("select * from users where id=" + untrusted);
        t.batchUpdate("select * from users where id=" + untrusted);
        t.batchUpdate("select * from users where id=?");

        t.execute("select * from users where id=?");
        t.execute("select * from users where id=" + untrusted);
        t.execute("select * from users where id=" + untrusted, (PreparedStatementCallback<? extends Object>) null);
        t.execute("select * from users where id=" + untrusted, (CallableStatementCallback<? extends Object>) null);
    }
}
