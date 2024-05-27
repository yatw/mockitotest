package com.yatw.mockitotest.scenarioDAO;

public class Scenario {
    private String id;
    private String name;

    public Scenario(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String setId() {
        return id;
    }
    public String getName(){
        return name;
    }

    public String toString(){
        return "Scenario{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
