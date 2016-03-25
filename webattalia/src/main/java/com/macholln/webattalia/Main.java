package com.macholln.webattalia;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
        get("/goodbye", (req, res) -> "<STRONG>GOODBYE RYAN</STRONG>");
    }
}