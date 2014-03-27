package com.mc.java8;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptInJava {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {

        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");


        engine.eval("function p(s) { print(s) }");

        engine.eval("p('Hello from javascript');");

        Invocable inv = (Invocable) engine;
        inv.invokeFunction("p", "hello with invocation");

    }
}
