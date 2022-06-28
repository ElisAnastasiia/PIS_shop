package com.shop.Controller;

public enum ConfigPath {
    home("/home.jsp"),
    login("/login.jsp"),
    register("/register.jsp"),
    profile("/profile.jsp"),
    users("/users.jsp"),
    products("/products.jsp")
    ;
    private final String jspPath;
    ConfigPath(String jspPath){
        this.jspPath = jspPath;
    }

    public String getJspPath() {
        return jspPath;
    }
}
